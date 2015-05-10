/*
 * @author     ucchy
 * @license    LGPLv3
 * @copyright  Copyright ucchy 2015
 */
package org.bitbucket.ucchy.fnafim.game;

import org.bitbucket.ucchy.fnafim.FiveNightsAtFreddysInMinecraft;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Foxyの行動タスク
 * @author ucchy
 */
public class FoxyMovementTask extends BukkitRunnable {

    private GameSession session;
    private boolean isEnd;
    private int seconds;

    protected FoxyMovementTask(GameSession session, int seconds) {
        this.session = session;
        this.seconds = seconds;
        isEnd = false;
    }

    @Override
    public void run() {
        session.onFoxyMovementEnd();
        isEnd = true;
    }

    public void start() {
        runTaskLater(FiveNightsAtFreddysInMinecraft.getInstance(), 20 * seconds);
    }

    public void end() {
        cancel();
        isEnd = true;
    }

    public boolean isEnded() {
        return isEnd;
    }
}
