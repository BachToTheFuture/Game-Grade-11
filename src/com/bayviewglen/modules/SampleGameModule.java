package com.bayviewglen.modules;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

import com.bayviewglen.gameutils.Action;
import com.bayviewglen.gameutils.ClipsLoader;
import com.bayviewglen.gameutils.GamePanel;
import com.bayviewglen.utils.StringUtils;
import com.bayviewglen.vo.Player;
import com.bayviewglen.windows.GameGUI;

public class SampleGameModule extends GamePanel {
	
	private GameGUI parent;
	private ClipsLoader clipsLoader;
	private Player player;
	
	
	public SampleGameModule(GameGUI parentFrame, long period, FileInputStream images, String sounds){
		super(images, period);
		actionStack = new Stack<Action>();
	
		clipsLoader = new ClipsLoader(sounds);
		
		player = new Player("HERO", PWIDTH, PHEIGHT, imsLoader, period, clipsLoader);		
		parent = parentFrame;
						
		// load the background image	
		setBgImage(imsLoader.getImage("samplebackground"));
		sprites.add(player.getSprite());
	}
	
	// handles termination and game-play keys
	protected void processKeyPressed(KeyEvent e){
		super.processKey(e);
		int keyCode = e.getKeyCode();

		// game-play keys
		if (!isPaused() && !isGameOver()) {
			if (keyCode == KeyEvent.VK_LEFT){
			/*	if (!player.isMoving()){
					player.setMoving(true);
					player.moveLeft();
				}
				*/
				updateActionStack("com.bayviewglen.vo.Character", "moveLeft",false,  player);
			
			}
			else if (keyCode == KeyEvent.VK_RIGHT){
			/*
				if (!player.isMoving()){
					player.setMoving(true);
					player.moveRight();
				}
				*/
				updateActionStack("com.bayviewglen.vo.Character", "moveRight", false, player);
			}else if (keyCode == KeyEvent.VK_A){
				updateActionStack("com.bayviewglen.vo.Character", "attack", true, player, 1);
				//player.attack(1);
			}else if (keyCode == KeyEvent.VK_Z){
				updateActionStack("com.bayviewglen.vo.Character", "attack", true, player, 2);
				// player.attack(2);
			}
		}
	}
	
	// handles termination and game-play keys
	protected void processKeyReleased(KeyEvent e){
		int keyCode = e.getKeyCode();

		// game-play keys
		if (!isPaused() && !isGameOver()) {
			if (keyCode == KeyEvent.VK_LEFT){
				updateActionStack("com.bayviewglen.vo.Character", "stayStill", true, "moveLeft", player);
			}else if (keyCode == KeyEvent.VK_RIGHT)
				updateActionStack("com.bayviewglen.vo.Character", "stayStill", true, "moveRight", player);
		}
	}
	
	private void updateActionStack(String className, String methodName, boolean runOnce, Object object, Object... arguments) {
		updateActionStack(className, methodName, runOnce, null, object, arguments);
		
	}
	
	private void updateActionStack(String className, String methodName, boolean runOnce, String antiMethodName, Object object, Object... arguments) {
		Method antiMethod = null;
		Method method = null;
		
		try {
			Class<?> c = Class.forName(className);
			
			Class<?>[] classes = new Class<?>[arguments.length];
			if (arguments.length!=0){
				int i = 0;
				for (Object o : arguments){
					classes[i++] = o.getClass();
				}
			}
			
			method = c.getDeclaredMethod(methodName, classes);
			if (!StringUtils.isEmpty(antiMethodName)){
				antiMethod = c.getDeclaredMethod(antiMethodName);
			}
			
			Action action = new Action(method, runOnce, new Action(antiMethod), object, arguments);
			if (actionStack.search(action)==-1){
				actionStack.push(action);
				actionStack.peek().setActive(false);
											
				if (action.hasAntiAction() && actionStack.contains(action)){
					actionStack.remove(action.getAntiAction());
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}

	public void run(){
		super.run();
	}
}
