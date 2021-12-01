package team.service;

import team.model.Match;
import team.model.Team;

public interface ICreateService {
    Match create(Team homeTeam, Team awayTeam);
}
