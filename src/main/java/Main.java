import lombok.extern.slf4j.Slf4j;
import team.model.Team;
import team.service.ITeamService;
import team.service.TeamService;

import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {

        ITeamService teamService = new TeamService();
        Scanner command = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("--- Welcome to the Football World Cup Score Analysis Board ---");
        while(isRunning){
            System.out.println("--- Please type one of the following commands: create, summary or exit. ---");
            switch (command.nextLine()) {
                case "create" -> {
                    Scanner teamDataScanner = new Scanner(System.in);
                    try {
                        System.out.println("Type the home team name.");
                        String homeTeamName = teamDataScanner.nextLine();

                        System.out.println("Type the home team score.");
                        int homeTeamScore = teamDataScanner.nextInt();
                        teamDataScanner.nextLine();

                        System.out.println("Type the away team name.");
                        String awayTeamName = teamDataScanner.nextLine();

                        System.out.println("Type the away team score.");
                        int awayTeamScore = teamDataScanner.nextInt();
                        teamDataScanner.nextLine();

                        teamService.create(new Team(homeTeamName, homeTeamScore), new Team(awayTeamName, awayTeamScore));
                    } catch (InputMismatchException e) {
                        log.error("There was an error in the input, please make sure that the score is a number.");
                    }

                }
                case "summary" -> teamService.summary();
                case "exit" -> {
                    System.out.println("The board is now closed.");
                    isRunning = false;
                }
                default -> System.out.println("Command not recognized!");
            }
        }
        command.close();
    }
}
