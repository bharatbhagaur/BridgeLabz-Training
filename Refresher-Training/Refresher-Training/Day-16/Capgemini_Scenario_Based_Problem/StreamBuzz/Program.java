import java.util.*;

class CreatorStats {

    private String CreatorName;
    private double[] WeeklyLikes;

    public String getCreatorName() {
        return CreatorName;
    }

    public void setCreatorName(String creatorName) {
        CreatorName = creatorName;
    }

    public double[] getWeeklyLikes() {
        return WeeklyLikes;
    }

    public void setWeeklyLikes(double[] weeklyLikes) {
        WeeklyLikes = weeklyLikes;
    }
}


public class Program {

    public static List<CreatorStats> EngagementBoard = new ArrayList<>();

    // Register Creator
    public void RegisterCreator(CreatorStats record) {
        EngagementBoard.add(record);
    }

    // Get Top Post Counts
    public Dictionary<String, Integer> GetTopPostCounts(
            List<CreatorStats> records, double likeThreshold) {

        Dictionary<String, Integer> result = new Dictionary<>();

        for (CreatorStats creator : records) {

            int count = 0;

            for (double likes : creator.getWeeklyLikes()) {

                if (likes >= likeThreshold) {
                    count++;
                }
            }

            if (count > 0) {
                result.put(creator.getCreatorName(), count);
            }
        }

        return result;
    }

    // Calculate Average Likes
    public double CalculateAverageLikes() {

        double total = 0;
        int count = 0;

        for (CreatorStats creator : EngagementBoard) {

            for (double likes : creator.getWeeklyLikes()) {
                total += likes;
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return total / count;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Program program = new Program();

        while (true) {

            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");

            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("Enter Creator Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter weekly likes (Week 1 to 4):");

                    double[] likes = new double[4];

                    for (int i = 0; i < 4; i++) {
                        likes[i] = sc.nextDouble();
                    }
                    sc.nextLine();

                    CreatorStats creator = new CreatorStats();

                    creator.setCreatorName(name);
                    creator.setWeeklyLikes(likes);

                    program.RegisterCreator(creator);

                    System.out.println("Creator registered successfully");

                    break;


                case 2:

                    System.out.println("Enter like threshold:");

                    double threshold = sc.nextDouble();
                    sc.nextLine();

                    Dictionary<String, Integer> result =
                            program.GetTopPostCounts(
                                    EngagementBoard,
                                    threshold
                            );

                    if (result.isEmpty()) {

                        System.out.println(
                                "No top-performing posts this week"
                        );

                    } else {

                        for (Map.Entry<String, Integer> entry :
                                result.entrySet()) {

                            System.out.println(
                                    entry.getKey() + " - " +
                                    entry.getValue()
                            );
                        }
                    }

                    break;


                case 3:

                    double average =
                            program.CalculateAverageLikes();

                    System.out.println(
                            "Overall average weekly likes: " +
                            (int) average
                    );

                    break;


                case 4:

                    System.out.println(
                            "Logging off - Keep Creating with StreamBuzz!"
                    );

                    sc.close();
                    return;


                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}