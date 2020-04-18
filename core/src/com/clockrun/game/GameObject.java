package com.clockrun.game;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.utils.Disposable;

public class GameObject extends ModelInstance implements Disposable {

    private Model model;
    public GameObject(Model model, String node) {
        super(model, node);
        this.model = model;
    }



    @Override
    public void dispose() {}
}
