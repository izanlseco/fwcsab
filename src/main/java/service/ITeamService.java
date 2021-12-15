package service;

import model.Match;
import model.Team;

import java.util.ArrayList;

public interface ITeamService {

    void create(Team homeTeam, Team awayTeam);
    ArrayList<Match> summary();
}
