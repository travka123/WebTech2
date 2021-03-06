package bsuir.webtech.lab4.business;

import bsuir.webtech.lab4.business.Beans.Room;

import java.util.List;

public class RoomsService {

    private final RoomsRepository roomsRepository;

    public RoomsService(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public List<Room> getAllRooms() {
        return roomsRepository.getRooms();
    }

    public List<Room> getVisibleRooms() {
        return roomsRepository.getVisibleRooms();
    }

    public Room getRoomById(int roomId) {
        return roomsRepository.getRoomById(roomId);
    }

    public void changeRoomVisibility(int roomId) {
        Room room = roomsRepository.getRoomById(roomId);
        if (room != null) {
            room.setHidden(!room.isHidden());
            roomsRepository.update(room);
        }
    }
}
