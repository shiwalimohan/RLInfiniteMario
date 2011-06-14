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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class consoleTrainer {

		public static void main(String[] args) throws InterruptedException, IOException {

                int whichTrainingMDP = 1; // select the MDP to load

                long timeTaken=0;
                long startTime, stopTime;
                
                if(args.length < 1){
        			System.out.println("trainer: you forgot the config file maybe.");
        			System.exit(0);
        		}
                
                Properties configFile = new Properties();
                FileInputStream in = new FileInputStream(args[0]);
                configFile.load(in);
                int seed = Integer.parseInt(configFile.getProperty("seed"));
                int levelType = Integer.parseInt(configFile.getProperty("level-type"));
                int levelDifficulty = Integer.parseInt(configFile.getProperty("level-difficulty"));
                int levelWidth = Integer.parseInt(configFile.getProperty("level-width"));
                int maxSteps = Integer.parseInt(configFile.getProperty("max-steps"));
                double rewardGoal = Double.parseDouble(configFile.getProperty("reward-goal"));
                double rewardDeath = Double.parseDouble(configFile.getProperty("reward-death"));
                double rewardStep = Double.parseDouble(configFile.getProperty("reward-step"));
                double rewardCoin = Double.parseDouble(configFile.getProperty("reward-coin"));
                double rewardKill = Double.parseDouble(configFile.getProperty("reward-kill"));
                double speedWalk = Double.parseDouble(configFile.getProperty("speed-walk"));
                double speedRun = Double.parseDouble(configFile.getProperty("speed-run"));
                double speedJump = Double.parseDouble(configFile.getProperty("speed-jump"));
                double speedSlideJump = Double.parseDouble(configFile.getProperty("speed-slidejump"));
                double accelFall = Double.parseDouble(configFile.getProperty("accel-fall"));
                int jumpTime = Integer.parseInt(configFile.getProperty("jump-time"));
                int slideJumpTime = Integer.parseInt(configFile.getProperty("slidejump-time"));
                

                consoleTrainerHelper.loadPMario(seed,levelType,levelDifficulty,levelWidth,maxSteps,rewardGoal,
                		rewardDeath,rewardStep,rewardCoin,rewardKill,speedWalk,speedRun,speedJump,speedSlideJump,accelFall,jumpTime
                		,slideJumpTime);

                RLGlue.RL_init();

                int episodeCount=Integer.parseInt(configFile.getProperty("number-of-runs")); //number of episodes to run
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
