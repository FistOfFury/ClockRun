package com.clockrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.utils.Disposable;

public class GameObject extends ModelInstance implements Disposable {

    private Model model;
    private int cur_road;
    static int NUM_ROADS = 3;

    public GameObject(Model model, int cur_road) {
        super(model);
        this.model = model;
        this.cur_road = cur_road;
    }

    public void move_left()
    {
        this.cur_road = (this.cur_road - 1 ) % GameObject.NUM_ROADS;
        this.transform.trn(new Vector3(-((float)Gdx.graphics.getWidth() / NUM_ROADS),0, 0));
    }

    public void move_right()
    {
        this.cur_road = (this.cur_road + 1 ) % NUM_ROADS;
        this.transform.trn(new Vector3((float)Gdx.graphics.getWidth() / NUM_ROADS,0, 0));
    }

    private void update_Road()
    {
        int x_place = (int)((Gdx.graphics.getWidth() * (NUM_ROADS + 0.5)) / NUM_ROADS );
        Vector3 cur_place = this.transform.getTranslation(new Vector3());
        this.transform.setTranslation(new Vector3(x_place,cur_place.y,cur_place.z));
    }



    @Override
    public void dispose() {}
}
