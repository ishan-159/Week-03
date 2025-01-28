package singlylinkedlist.socialmediafriend;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SocialMediaFriends {
    private UserNode head = null;

    // Add a new user
    public void addUser(int userID, String name, int age) {
        UserNode newUser = new UserNode(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Find a user by ID
    private UserNode findUser(int userID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection
    public void addFriendConnection(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        // Add user2 to user1's friend list
        addFriendToList(user1, userID2);

        // Add user1 to user2's friend list
        addFriendToList(user2, userID1);

        System.out.println("Friend connection added between " + userID1 + " and " + userID2);
    }

    private void addFriendToList(UserNode user, int friendID) {
        FriendNode newFriend = new FriendNode(friendID);
        if (user.friendList == null) {
            user.friendList = newFriend;
        } else {
            FriendNode temp = user.friendList;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newFriend;
        }
    }

    // Remove a friend connection
    public void removeFriendConnection(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        // Remove user2 from user1's friend list
        removeFriendFromList(user1, userID2);

        // Remove user1 from user2's friend list
        removeFriendFromList(user2, userID1);

        System.out.println("Friend connection removed between " + userID1 + " and " + userID2);
    }

    private void removeFriendFromList(UserNode user, int friendID) {
        if (user.friendList == null) return;

        if (user.friendList.friendID == friendID) {
            user.friendList = user.friendList.next;
            return;
        }

        FriendNode prev = user.friendList;
        FriendNode current = user.friendList.next;

        while (current != null) {
            if (current.friendID == friendID) {
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        Set<Integer> friendsOfUser1 = new HashSet<>();
        FriendNode temp = user1.friendList;
        while (temp != null) {
            friendsOfUser1.add(temp.friendID);
            temp = temp.next;
        }

        List<Integer> mutualFriends = new ArrayList<>();
        temp = user2.friendList;
        while (temp != null) {
            if (friendsOfUser1.contains(temp.friendID)) {
                mutualFriends.add(temp.friendID);
            }
            temp = temp.next;
        }

        System.out.println("Mutual friends between " + userID1 + " and " + userID2 + ": " + mutualFriends);
    }

    // Display all friends of a user
    public void displayFriends(int userID) {
        UserNode user = findUser(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friendList;
        while (temp != null) {
            System.out.print(temp.friendID + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode friendTemp = temp.friendList;
            while (friendTemp != null) {
                count++;
                friendTemp = friendTemp.next;
            }
            System.out.println(temp.name + " has " + count + " friends.");
            temp = temp.next;
        }
    }

}

