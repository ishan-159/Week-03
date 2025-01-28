package singlylinkedlist.socialmediafriend;

public class Main {

    public static void main(String[] args) {
        SocialMediaFriends smf = new SocialMediaFriends();

        // Adding users
        smf.addUser(1, "Ishan", 25);
        smf.addUser(2, "Naman", 30);
        smf.addUser(3, "Om", 20);
        smf.addUser(4, "Harsh", 28);

        // Adding friend connections
        smf.addFriendConnection(1, 2);
        smf.addFriendConnection(1, 3);
        smf.addFriendConnection(2, 4);

        // Display friends
        smf.displayFriends(1);
        smf.displayFriends(2);

        // Find mutual friends
        smf.findMutualFriends(1, 2);

        // Remove a friend connection
        smf.removeFriendConnection(1, 3);

        // Display friends again
        smf.displayFriends(1);

        // Count friends for each user
        smf.countFriends();
    }
}
