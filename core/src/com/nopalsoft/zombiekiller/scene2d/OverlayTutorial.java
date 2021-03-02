package com.nopalsoft.zombiekiller.scene2d;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.I18NBundle;
import com.nopalsoft.zombiekiller.Assets;
import com.nopalsoft.zombiekiller.game.GameScreen;
import com.nopalsoft.zombiekiller.screens.Screens;

public class OverlayTutorial extends Group {

	LabelDialog currentDialog;

	LabelDialog helpPad;
	LabelDialog helpJump;
	LabelDialog helpFire;
	LabelDialog helpLifeBar;
	LabelDialog helpShieldBar;
	LabelDialog helpCollectSkulls;
	LabelDialog helpCollectGems;
	GameScreen gameScreen;

	public boolean isVisible;
	int numDialogShown = 0;

	I18NBundle idiomas;

	public OverlayTutorial(final GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		setSize(Screens.SCREEN_WIDTH, Screens.SCREEN_HEIGHT);
		setBackground();
		idiomas = gameScreen.game.idiomas;

		addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				showHelpDialog();
				return true;
			}
		});

		helpPad = new LabelDialog(idiomas.get("help_pad"), false);
		helpPad.sizeBy(-50, 10);
		helpPad.setPosition(gameScreen.pad.getX() + gameScreen.pad.getWidth() / 2f, gameScreen.pad.getY() + gameScreen.pad.getHeight() / 2f);

		helpJump = new LabelDialog(idiomas.get("help_jump"), false);
		helpJump.sizeBy(0, 10);
		helpJump.setPosition(gameScreen.btJump.getX() + gameScreen.btJump.getWidth() / 2f, gameScreen.btJump.getY() + gameScreen.btJump.getHeight()
				/ 2f);

		helpFire = new LabelDialog(idiomas.get("help_fire"), false);
		helpFire.sizeBy(0, 10);
		helpFire.setPosition(gameScreen.btFire.getX() + gameScreen.btFire.getWidth() / 2f, gameScreen.btFire.getY() + gameScreen.btFire.getHeight()
				/ 2f);

		helpLifeBar = new LabelDialog(idiomas.get("help_life"), true);
		helpLifeBar.sizeBy(-100, 15);
		helpLifeBar.setPosition(100, 340);

		helpShieldBar = new LabelDialog(idiomas.get("help_shield"), true);
		helpShieldBar.sizeBy(-50, 15);
		helpShieldBar.setPosition(100, 295);

		helpCollectSkulls = new LabelDialog(idiomas.get("help_collect_skulls"), false);
		helpCollectSkulls.sizeBy(-300, 40);
		helpCollectSkulls.setPosition(465, 290);

		helpCollectGems = new LabelDialog(idiomas.get("help_collect_gems"), false);
		helpCollectGems.sizeBy(-570, 60);
		helpCollectGems.setPosition(250, 220);

		showHelpDialog();

	}

	private void showHelpDialog() {
		if (currentDialog != null)
			currentDialog.remove();

		switch (numDialogShown) {
		case 0:
			currentDialog = helpPad;
			break;
		case 1:
			currentDialog = helpJump;
			break;
		case 2:
			currentDialog = helpFire;
			break;
		case 3:
			currentDialog = helpLifeBar;
			break;
		case 4:
			currentDialog = helpShieldBar;
			break;
		case 5:
			currentDialog = helpCollectSkulls;
			break;
		case 6:
			currentDialog = helpCollectGems;
			break;

		default:
			hide();
			break;
		}
		numDialogShown++;
		addActor(currentDialog);
	}

	public void show(Stage stage) {
		stage.addActor(this);
		isVisible = true;
	}

	public void hide() {
		isVisible = false;
		remove();
	}

	private void setBackground() {
		Image img = new Image(Assets.pixelNegro);
		img.setSize(getWidth(), getHeight());
		img.getColor().a = .4f;
		addActor(img);

	}
}
