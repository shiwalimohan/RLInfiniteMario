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
import rlVizLib.general.ParameterHolder;
import rlVizLib.messaging.environmentShell.EnvShellListRequest;
import rlVizLib.messaging.environmentShell.EnvShellListResponse;
import rlVizLib.messaging.environmentShell.EnvShellLoadRequest;
import rlVizLib.messaging.environmentShell.EnvShellUnLoadRequest;

public class consoleTrainerHelper{
	private static boolean currentlyLoaded=false;
	
	private static void unload(){
		EnvShellUnLoadRequest.Execute();
	}
	private static void load(String envNameString, ParameterHolder theParams){
		if(currentlyLoaded)unload();
		
		EnvShellLoadRequest.Execute(envNameString,theParams);
		currentlyLoaded=true;
	}
	
	private static ParameterHolder preload(String envNameString){
		EnvShellListResponse ListResponse = EnvShellListRequest.Execute();

		int thisEnvIndex=ListResponse.getTheEnvList().indexOf(envNameString);
		
		ParameterHolder p = ListResponse.getTheParamList().get(thisEnvIndex);
		return p;
		
	}
	
	private static void preloadAndLoad(String envNameString){
		ParameterHolder p=preload(envNameString);
		load(envNameString,p);
	}

	/*
	* Octopus has no parameters 
	* 
	*/
	public static void loadOctopus(){
		String theEnvString="Octopus - Java";
		ParameterHolder theParams=preload(theEnvString);
				
		load(theEnvString, theParams);
	}


	/*
	* Tetris has an integer parameter called pnum that takes values in [0,19]
	* Setting this parameter changes the exact tetris problem you are solving
	*/
	public static void loadTetris(int whichParamSet){
		String theEnvString="GeneralizedTetris - Java";
		ParameterHolder theParams=preload(theEnvString);
		theParams.setIntegerParam("pnum",whichParamSet);
		
		load(theEnvString, theParams);
	}

	/*
	* Acrobot has an integer parameter called pnum that takes values in [0,39]
	* Setting this parameter changes the exact Acrobot problem you are solving
	* MDP 0 is standard acrobot
	*/
	public static void loadAcrobot(int whichParamSet){
		String theEnvString="GeneralizedAcrobot - Java";
		ParameterHolder theParams=preload(theEnvString);
		theParams.setIntegerParam("pnum",whichParamSet);
		
		load(theEnvString, theParams);
	}
	

    public static void loadMario(int levelSeed, int levelType, int levelDifficulty, int instance){
		String theEnvString="GeneralizedMario - Java";
		ParameterHolder theParams=preload(theEnvString);

		theParams.setBooleanParam("fast",true);
		theParams.setBooleanParam("dark",true);
		theParams.setIntegerParam("level seed",levelSeed);
		theParams.setIntegerParam("level type",levelType);
		theParams.setIntegerParam("level difficulty",levelDifficulty);
		theParams.setIntegerParam("instance",instance);
		
		load(theEnvString, theParams);
	}


public static void loadPMario(int levelSeed, int levelType, int levelDifficulty, int width, int maxSteps, double rGoal, double rDeath, double rStep, double rCoin, double rKill, double sWalk, double sRun, double sJump, double sSlide, double aFall, int jTime, int sjTime){
                String theEnvString="ParameterizedMario - Java";
                ParameterHolder theParams=preload(theEnvString);

                theParams.setBooleanParam("fast",true);
                theParams.setBooleanParam("dark",true);
                theParams.setIntegerParam("level seed",levelSeed);
                theParams.setIntegerParam("level type",levelType);
                theParams.setIntegerParam("level difficulty",levelDifficulty);
                theParams.setIntegerParam("level width",width);
		theParams.setIntegerParam("max trial steps",maxSteps);
		theParams.setDoubleParam("reward goal",rGoal);
		theParams.setDoubleParam("reward death",rDeath);
		theParams.setDoubleParam("reward step",rStep);
		theParams.setDoubleParam("reward coin",rCoin);
		theParams.setDoubleParam("reward kill",rKill);
		theParams.setDoubleParam("speed walk",sWalk);
		theParams.setDoubleParam("speed run",sRun);
		theParams.setDoubleParam("speed jump",sJump);
		theParams.setDoubleParam("speed slidejump",sSlide);
		theParams.setDoubleParam("accel fall",aFall);
		theParams.setIntegerParam("jump time",jTime);
		theParams.setIntegerParam("slidejump time",sjTime);

                load(theEnvString, theParams);
        }

	/*
	* Helicopter has an integer parameter called pnum that takes values in [0,9]
	* Setting this parameter changes the exact helicopter problem you are solving
	*/
	public static void loadHelicopter(int whichParamSet){
		String theEnvString="GeneralizedHelicopter - Java";
		ParameterHolder theParams=preload(theEnvString);
		theParams.setIntegerParam("pnum",whichParamSet);
		
		load(theEnvString, theParams);
	}

	/*
	* Polyathlon has an integer parameter called pnum that takes values in [0,5]
	* Setting this parameter changes the exact helicopter problem you are solving
	*/
	public static void loadPolyathlon(int whichParamSet){
		String theEnvString="TrainingPolyathlon - Java";
		ParameterHolder theParams=preload(theEnvString);
		theParams.setIntegerParam("pnum",whichParamSet);
		
		load(theEnvString, theParams);
	}
	
	/*
	* Task spec tester takes no parameters
	*/
	public static void loadTaskSpecTester(){
		String theEnvString="TaskSpecTester - Java";
		preloadAndLoad(theEnvString);
	}
}
