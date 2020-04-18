package com.clockrun.game;

import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

public class Player extends GameObject {
    private int lives;
    private int score;

    public Player()
    {
        super(new ModelBuilder().createBox(5f, 5f, 5f,
                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
                Usage.Position | Usage.Normal), GameObject.NUM_ROADS / 2);
        this.score = 0;
        this.lives = 3;
    }

    public void tap(float x, float y)
    {
        int X_LIMIT = Gdx.graphics.getWidth() / 2;
        int Y_LIMIT = Gdx.graphics.getHeight() / 2;

        if (x < X_LIMIT)
        {
            if (y < Y_LIMIT)
            {
                //LEFT - UPPER
                this.move_left();
            }

            else
            {
                //LEFT - LOWER
                this.move_left();
            }
        }
        else
        {
            if (y < Y_LIMIT)
            {
                //RIGHT - UPPER
                this.move_right();
            }

            else
            {
                //RIGHT - LOWER
                this.move_right();
            }
        }

    }


}
