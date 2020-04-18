package com.clockrun.game;

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
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import javax.jws.WebParam;

/**
 * See: http://blog.xoppa.com/basic-3d-using-libgdx-2/
 * @author Xoppa
 */
public class main_game implements ApplicationListener, GestureListener {
    public Environment environment;
    public PerspectiveCamera cam;

    public ModelBatch modelBatch;
    public Model model;

    private Player player;
    public ArrayList<GameObject> instances;
    private ArrayList<ModelInstance> bb;

    @Override
    public void create() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        modelBatch = new ModelBatch();

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(10f, 10f, 10f);
        cam.lookAt(0,0,0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

        this.instances = new ArrayList<GameObject>();
        bb = new ArrayList<ModelInstance>();

        this.player = new Player();
        this.instances.add(this.player);
//        instances.add(new GameObject(new ModelBuilder().createBox(5f, 5f, 5f,
//                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
//                Usage.Position | Usage.Normal), "bb", GameObject.NUM_ROADS / 2));
//
//        ModelBuilder mb = new ModelBuilder();
//        model = mb.createBox(5f, 5f, 5f,
//                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
//                Usage.Position | Usage.Normal);
//        bb.add(new ModelInstance(model));

        GestureDetector gd = new GestureDetector(this);
        Gdx.input.setInputProcessor(gd);

    }

    @Override
    public void render() {

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        modelBatch.begin(cam);

        modelBatch.render(instances, environment);
        modelBatch.render(bb, environment);

        modelBatch.end();
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        model.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        // ignored
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        this.player.tap(x, y);

        return true;
    }

    @Override
    public boolean longPress(float x, float y) {
        // ignored
        return true;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        // ignored
        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        // ignored
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        // ignored
        return true;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        // ignored
        return true;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        // ignored
        return true;
    }

    @Override
    public void pinchStop() {
        // ignored
    }
}