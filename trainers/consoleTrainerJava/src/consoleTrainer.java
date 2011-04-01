/* console Trainer for RL Competition
* Copyright (C) 2007, Brian Tanner brian@tannerpages.com (http://brian.tannerpages.com/)
* 
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA. */
import org.rlcommunity.rlglue.codec.RLGlue;
import java.util.*;

public class consoleTrainer {

		public static void main(String[] args) throws InterruptedException {

                int whichTrainingMDP = 1; // select the MDP to load

                long timeTaken=0;
                long startTime, stopTime;

                consoleTrainerHelper.loadPMario(121,0,1,320,1000,100.0,-10.0,-0.01,1,1,0.6,1.2,-1.9,-2.0,0.82,7,-6);

                RLGlue.RL_init();

                int episodeCount=5000; //number of episodes to run
                int maxEpisodeLength=2000; //set a maxEpisodeLength to cut off long episodes

                int totalSteps=0;//counter for the total number of steps taken to finish all episodes
                //run the episodes with RL_episode(maxEpisodeLength)


                startTime=System.nanoTime();
                for(int i=0;i<episodeCount;i++){
                        RLGlue.RL_episode(maxEpisodeLength);
                        totalSteps+=RLGlue.RL_num_steps();
                        System.out.println("Episode: "+i+" steps: "+RLGlue.RL_num_steps());
                }
                stopTime=System.nanoTime();
                timeTaken=(stopTime-startTime)/1000000000;

                System.out.println("totalSteps is: "+totalSteps);
                System.out.println("totalTime is: "+timeTaken);

                //clean up the environment and end the program
                RLGlue.RL_cleanup();
        }

}
