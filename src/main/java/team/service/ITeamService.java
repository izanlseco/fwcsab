package team.service;

import team.model.Match;
import team.model.Team;

import java.util.ArrayList;

public interface ITeamService {

    boolean create(Team homeTeam, Team awayTeam);
    ArrayList<Match> summary();
}
