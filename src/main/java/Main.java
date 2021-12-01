import team.model.Team;
import team.service.ITeamService;
import team.service.TeamService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        ITeamService teamService = new TeamService();
        Scanner command = new Scanner(System.in);
        boolean isRunning = true;

        log.info("--- Welcome to the Football World Cup Score Analysis Board ---");
        while(isRunning){
            log.info("--- Please type one of the following commands: create, summary or exit. ---");
            switch (command.nextLine()) {
                case "create" -> {
                    Scanner teamDataScanner = new Scanner(System.in);
                    try {
                        log.info("Type the home team name.");
                        String homeTeamName = teamDataScanner.nextLine();

                        log.info("Type the home team score.");
                        int homeTeamScore = teamDataScanner.nextInt();
                        teamDataScanner.nextLine();

                        log.info("Type the away team name.");
                        String awayTeamName = teamDataScanner.nextLine();

                        log.info("Type the away team score.");
                        int awayTeamScore = teamDataScanner.nextInt();
                        teamDataScanner.nextLine();

                        teamService.create(new Team(homeTeamName, homeTeamScore), new Team(awayTeamName, awayTeamScore));
                    } catch (InputMismatchException e) {
                        log.severe("There was an error in the input, please make sure that the score is a number.");
                    }

                }
                case "summary" -> teamService.summary();
                case "exit" -> {
                    log.info("The board is now closed.");
                    isRunning = false;
                }
                default -> log.info("Command not recognized!");
            }
        }
        command.close();
    }
}
