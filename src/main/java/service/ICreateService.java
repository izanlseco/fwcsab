package service;

import model.Match;
import model.Team;

public interface ICreateService {
    Match create(Team homeTeam, Team awayTeam);
}
