package singlylinkedlist.socialmediafriend;

import java.util.*;

class FriendNode {
    int friendID;
    FriendNode next;

    public FriendNode(int friendID) {
        this.friendID = friendID;
        this.next = null;
    }
}

class UserNode {
    int userID;
    String name;
    int age;
    FriendNode friendList; // Linked list of friends
    UserNode next;

    public UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}
