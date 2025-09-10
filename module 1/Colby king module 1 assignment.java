//Colby king module 1 assignment
private static final int TOTAL_CARDS = 52;
private static final int DISPLAY_COUNT = 4;
private static final String CARD_FOLDER = "C:"C:\Users\CO876KI\Desktop\school\csd 420\module 1\AssignmentCards (2)";

private final ImageView[] cardSlots = new ImageView[DISPLAY_COUNT];

@Override
public void start(Stage primaryStage) {
    VBox root = new VBox(15);
    HBox cardBox = new HBox(10);
    Button refreshButton = new Button("Refresh");

    for (int i = 0; i < DISPLAY_COUNT; i++) {
        cardSlots[i] = new ImageView();
        cardSlots[i].setFitWidth(100);
        cardSlots[i].setPreserveRatio(true);
        cardBox.getChildren().add(cardSlots[i]);
    }

    loadRandomCards();

    refreshButton.setOnAction(e -> loadRandomCards());
    root.getChildren().addAll(cardBox, refreshButton);

}

private void loadRandomCards() {
    Set<Integer> selectedCards = new HashSet<>();
    Random random = new Random();

    while (selectedCards.size() < DISPLAY_COUNT) {
        selectedCards.add(random.nextInt(TOTAL_CARDS) + 1);
    }

    int index = 0;
    for (int cardNum : selectedCards) {
        File file = new File(CARD_FOLDER + cardNum + ".png");
        Image image = new Image(file.toURI().toString());
        cardSlots[index++].setImage(image);
    }
}

public static void main(String[] args) {
    launch(args);
}