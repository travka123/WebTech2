package bsuir.webtech.lab4.business;

import bsuir.webtech.lab4.business.Beans.User;

import java.security.NoSuchAlgorithmException;

public class AuthorizationService {
    private final UsersRepository usersRepository;
    private final SaltShaker saltShaker;

    public AuthorizationService(UsersRepository usersRepository, SaltShaker saltShaker) {
        this.usersRepository = usersRepository;
        this.saltShaker = saltShaker;
    }

    public String createSalt() {
        return saltShaker.createSalt();
    }

    public boolean tryAuthorize(UserSession userSession, String login, String passwordSaltHash, String salt) {

        if (!saltShaker.tryUse(salt)) {
            return false;
        }

        User user = usersRepository.getAccountByLogin(login);
        if (user == null) {
            return false;
        }

        try {
            if (!passwordSaltHash.equals(Cryptography.getHash(user.getPassHash() + salt))) {
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            return false;
        }

        userSession.setUserId(user.getId());
        userSession.setUserRole(user.getRole());
        userSession.setUserName(user.getName());
        return true;
    }

    public boolean tryRegister(UserSession userSession, String login, String name, String passwordHash) {
        if ((userSession == null) || (login == null) || (name == null) || (passwordHash == null)) {
            return false;
        }

        if (login.length() <= 2) {
            return false;
        }

        if (usersRepository.getAccountByLogin(login) != null) {
            return false;
        }

        usersRepository.add(new User(name, login, passwordHash, "user"));

        return true;
    }
}
