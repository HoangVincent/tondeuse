package command;

import bean.Tondeuse;

/**
 * Created by Suguru on 06/12/2015.
 */
public interface Command {

    void executer(Tondeuse tondeuse);

}
