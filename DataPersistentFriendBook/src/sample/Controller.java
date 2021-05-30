package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class Controller {
    public TextField FAge;
    public TextField FPet;
    public TextField FName;

    public TextField GName;
    public ListView<String> GList;

    public ListView<String> allFriends;
    public Label selectedGName;

    List<Group> groups = null;

    FileManager fileManager = new FileManager();

    public void createFriend(ActionEvent actionEvent) throws IOException {
        String GName = selectedGName.getText();
        Group group = fileManager.findGroupByName(GName);
        if (group == null) {
            return;
        }
        String name = FName.getText();
        int age = Integer.parseInt(FAge.getText());
        String favoriteColor = FPet.getText();
        Friend friend = new Friend(name, age, favoriteColor);
        fileManager.putFriendInGroup(friend, group);
        FName.clear();
        FAge.clear();
        FPet.clear();
    }

    public void loadFriends(ActionEvent actionEvent) throws IOException {
        allFriends.getItems().clear();
        String GName = selectedGName.getText();
        Group group = fileManager.findGroupByName(GName);
        if (group == null) {
            return;
        }
        List<Friend> friends = fileManager.getFriends(group);
        for (Friend friend : friends) {
            allFriends.getItems().add(friend.toDataLine());
        }
    }

    public void addNewGroup(ActionEvent actionEvent) throws IOException {
        String GNameText = GName.getText();
        if (GNameText != null && !GNameText.isEmpty()) {
            Group group = new Group(
                    GNameText,
                    "group." + GNameText.replaceAll(" ", "") + ".txt"
            );
            fileManager.addGroupInTxt(group);
            GName.clear();
            loadAllGroups(actionEvent);
        }
    }

    public void selectGroup(ActionEvent actionEvent) {
        String selectedName = GList.getSelectionModel().getSelectedItem();
        selectedGName.setText(selectedName);
    }

    public void loadAllGroups(ActionEvent actionEvent) throws IOException {
        GList.getItems().clear();
        groups = fileManager.loadGroups();
        List<String> names = Group.convertGroupsToNames(groups);
        ObservableList<String> observableNames = FXCollections.observableArrayList(names);
        GList.setItems(observableNames);
    }
}
