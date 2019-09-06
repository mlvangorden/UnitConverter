package com.example.unitconverter;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    int fireLvl = 1;
    int grassLvl = 1;
    int waterLvl = 1;
    int darkLvl = 1;
    int currentPokemon = 0;

    boolean open1 = false;
    boolean open2 = false;
    boolean open3 = false;
    boolean open4 = false;
    boolean complete = false;
    boolean secret = false;
    boolean megaEvolved = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rel_layout);

        final ImageButton pokeball1 = findViewById(R.id.first_pokeball);
        final ImageButton pokeball2 = findViewById(R.id.second_pokeball);
        final ImageButton pokeball3 = findViewById(R.id.third_pokeball);
        final ImageButton pokeball4 = findViewById(R.id.fourth_pokeball);
        final ImageButton candy = findViewById(R.id.candy);
        final ImageButton pokemon = findViewById(R.id.pokemon);
        final ImageButton mega = findViewById(R.id.mega);

        final TextView level = findViewById(R.id.level);
        final TextView species = findViewById(R.id.species);

        //button plays cry of the current Pokémon
        pokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(megaEvolved){
                    if (currentPokemon == 1) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.venusaur_m);
                            mp.start();
                    } else if (currentPokemon == 2) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.charizard_m);
                            mp.start();
                    } else if (currentPokemon == 3) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.blastoise_m);
                            mp.start();
                    } else if (currentPokemon == 4) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.houndoom_m);
                            mp.start();
                    }
                }
                else {
                    if (currentPokemon == 1) {
                        if (grassLvl >= 32) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.venusaur);
                            mp.start();
                        } else if (grassLvl >= 16) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.ivysaur);
                            mp.start();
                        } else {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.bulbasaur);
                            mp.start();
                        }
                    } else if (currentPokemon == 2) {
                        if (fireLvl >= 36) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.charizard);
                            mp.start();
                        } else if (fireLvl >= 16) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.charmeleon);
                            mp.start();
                        } else {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.charmander);
                            mp.start();
                        }
                    } else if (currentPokemon == 3) {
                        if (waterLvl >= 36) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.blastoise);
                            mp.start();
                        } else if (waterLvl >= 16) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.wartortle);
                            mp.start();
                        } else {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.squirtle);
                            mp.start();
                        }
                    } else if (currentPokemon == 4) {
                        if (darkLvl >= 24) {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.houndoom);
                            mp.start();
                        } else {
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.houndour);
                            mp.start();
                        }
                    }
                }
            }
        });

        //button releases the Pokémon in the first ball, Bulbasaur
        pokeball1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!open1) {
                    pokeball1.setImageResource(R.drawable.pokeball_open);
                    pokeball2.setImageResource(R.drawable.pokeball);
                    pokeball3.setImageResource(R.drawable.pokeball);
                    pokeball4.setImageResource(R.drawable.duskball);
                    candy.setImageResource(R.drawable.rare_candy);
                    level.setText("LVL " + grassLvl);
                    currentPokemon = 1;
                    chooseGrass(pokemon, species, mega);
                    open1 = true;
                    open2 = false;
                    open3 = false;
                    open4 = false;
                    megaEvolved = false;
                }
                else{
                    pokeball1.setImageResource(R.drawable.pokeball);
                    returnPokemon(pokemon, candy, species, level, mega);
                    open1 = false;
                }
            }
        });

        //button releases the Pokémon in the second ball, Charmander
        pokeball2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!open2) {
                    pokeball1.setImageResource(R.drawable.pokeball);
                    pokeball2.setImageResource(R.drawable.pokeball_open);
                    pokeball3.setImageResource(R.drawable.pokeball);
                    pokeball4.setImageResource(R.drawable.duskball);
                    candy.setImageResource(R.drawable.rare_candy);
                    level.setText("LVL " + fireLvl);
                    currentPokemon = 2;
                    chooseFire(pokemon, species, mega);
                    open1 = false;
                    open2 = true;
                    open3 = false;
                    open4 = false;
                    megaEvolved = false;
                }
                else{
                    pokeball2.setImageResource(R.drawable.pokeball);
                    returnPokemon(pokemon, candy, species, level, mega);
                    open2 = false;
                }
            }
        });

        //button releases the Pokémon in the third ball, Squirtle
        pokeball3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!open3) {
                    pokeball1.setImageResource(R.drawable.pokeball);
                    pokeball2.setImageResource(R.drawable.pokeball);
                    pokeball3.setImageResource(R.drawable.pokeball_open);
                    pokeball4.setImageResource(R.drawable.duskball);
                    candy.setImageResource(R.drawable.rare_candy);
                    level.setText("LVL " + waterLvl);
                    currentPokemon = 3;
                    chooseWater(pokemon, species, mega);
                    open1 = false;
                    open2 = false;
                    open3 = true;
                    open4 = false;
                    megaEvolved = false;
                }
                else{
                    pokeball3.setImageResource(R.drawable.pokeball);
                    returnPokemon(pokemon, candy, species, level, mega);
                    open3 = false;
                }
            }
        });

        //button releases the Pokémon in the secret ball, Houndour
        pokeball4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!open4) {
                    pokeball1.setImageResource(R.drawable.pokeball);
                    pokeball2.setImageResource(R.drawable.pokeball);
                    pokeball3.setImageResource(R.drawable.pokeball);
                    pokeball4.setImageResource(R.drawable.duskball_open);
                    candy.setImageResource(R.drawable.rare_candy);
                    level.setText("LVL " + darkLvl);
                    currentPokemon = 4;
                    chooseDark(pokemon, species, mega);
                    open1 = false;
                    open2 = false;
                    open3 = false;
                    open4 = true;
                    megaEvolved = false;
                }
                else{
                    pokeball4.setImageResource(R.drawable.duskball);
                    returnPokemon(pokemon, candy, species, level, mega);
                    open4 = false;
                }
            }
        });

        //button levels up current Pokémon
        candy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                levelUp(level, pokeball4, mega);
                checkEvolve(pokemon, species);
            }
        });

        //mega stone used to mega evolve Pokémon
        mega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!megaEvolved) {
                    megaEvolved = true;
                    if (currentPokemon == 1) {
                            pokemon.setImageResource(R.drawable.venusaur_m);
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.venusaur_m);
                            mp.start();
                    } else if (currentPokemon == 2) {
                            pokemon.setImageResource(R.drawable.charizard_m);
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.charizard_m);
                            mp.start();
                    } else if (currentPokemon == 3) {
                            pokemon.setImageResource(R.drawable.blastoise_m);
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.blastoise_m);
                            mp.start();
                    } else if (currentPokemon == 4) {
                            pokemon.setImageResource(R.drawable.houndoom_m);
                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.houndoom_m);
                            mp.start();
                    }
                }
                else{
                    megaEvolved = false;
                    if (currentPokemon == 1) {
                        pokemon.setImageResource(R.drawable.venusaur);
                    } else if (currentPokemon == 2) {
                        pokemon.setImageResource(R.drawable.charizard);
                    } else if (currentPokemon == 3) {
                        pokemon.setImageResource(R.drawable.blastoise);
                    } else if (currentPokemon == 4) {
                        pokemon.setImageResource(R.drawable.houndoom);
                    }
                }
            }
        });

    }

    //increments level of current Pokémon
    public void levelUp(TextView lvl, ImageButton sec, ImageButton meg){
        if(currentPokemon == 1){
            if(grassLvl < 100) grassLvl++;
            lvl.setText("LVL " + grassLvl);
        }
        else if(currentPokemon == 2){
            if(fireLvl < 100) fireLvl++;
            lvl.setText("LVL " + fireLvl);
        }
        else if(currentPokemon == 3){
            if(waterLvl < 100) waterLvl++;
            lvl.setText("LVL " + waterLvl);
        }
        else if(currentPokemon == 4){
            if(darkLvl < 100) darkLvl++;
            lvl.setText("LVL " + darkLvl);
        }

        //if all three starting Pokémon are at LVL 100, unlocks a secret Poké Ball
        if( (grassLvl >= 100) && (fireLvl >= 100) && (waterLvl >= 100) ) {
            if(!secret) {
                secret = true;
                sec.setVisibility(VISIBLE);
                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.secret);
                mp.start();
            }
        }
        //plays victory fanfare once all four Pokémon reach LVL 100, unlocking Mega Stones
        if( (grassLvl >= 100) && (fireLvl >= 100) && (waterLvl >= 100) && (darkLvl == 100) ) {
            if(!complete){
                complete = true;
                meg.setVisibility(VISIBLE);
                MediaPlayer mp = MediaPlayer.create(this, R.raw.fanfare);
                mp.start();
            }
        }

    }

    //function for evolving each Pokémon once they reach the appropriate LVL
    public void checkEvolve(ImageButton x, TextView sp){
        //Bulbasaur line
        if(currentPokemon == 1){
            if(grassLvl == 32){
                x.setImageResource(R.drawable.venusaur);
                sp.setText(R.string.grass3);
                MediaPlayer mp = MediaPlayer.create(this, R.raw.venusaur);
                mp.start();

            }
            else if(grassLvl == 16){
                x.setImageResource(R.drawable.ivysaur);
                sp.setText(R.string.grass2);
                MediaPlayer mp = MediaPlayer.create(this, R.raw.ivysaur);
                mp.start();
            }
        }
        //Charmander line
        else if(currentPokemon == 2){
            if(fireLvl == 36){
                x.setImageResource(R.drawable.charizard);
                sp.setText(R.string.fire3);
                MediaPlayer mp = MediaPlayer.create(this, R.raw.charizard);
                mp.start();
            }
            else if(fireLvl == 16){
                x.setImageResource(R.drawable.charmeleon);
                sp.setText(R.string.fire2);
                MediaPlayer mp = MediaPlayer.create(this, R.raw.charmeleon);
                mp.start();
            }
        }
        //Squirtle line
        else if(currentPokemon == 3){
            if(waterLvl == 36){
                x.setImageResource(R.drawable.blastoise);
                sp.setText(R.string.water3);
                MediaPlayer mp = MediaPlayer.create(this, R.raw.blastoise);
                mp.start();
            }
            else if(waterLvl == 16){
                x.setImageResource(R.drawable.wartortle);
                sp.setText(R.string.water2);
                MediaPlayer mp = MediaPlayer.create(this, R.raw.wartortle);
                mp.start();
            }
        }
        //Houndour line
        else if(currentPokemon == 4){
            if(darkLvl == 24){
                x.setImageResource(R.drawable.houndoom);
                sp.setText(R.string.dark2);
                MediaPlayer mp = MediaPlayer.create(this, R.raw.houndoom);
                mp.start();
            }
        }

    }

    //opens Bulbasaur's Poké Ball
    public void chooseGrass(ImageButton x, TextView sp, ImageButton meg){
        currentPokemon = 1;
        if(grassLvl >= 32){
            x.setImageResource(R.drawable.venusaur);
            sp.setText(R.string.grass3);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.venusaur);
            mp.start();
        }
        else if(grassLvl >= 16){
            x.setImageResource(R.drawable.ivysaur);
            sp.setText(R.string.grass2);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.ivysaur);
            mp.start();
        }
        else{
            x.setImageResource(R.drawable.bulbasaur);
            sp.setText(R.string.grass1);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.bulbasaur);
            mp.start();
        }
        meg.setImageResource(R.drawable.grass);
    }

    //opens Charmander's Poké Ball
    public void chooseFire(ImageButton x, TextView sp, ImageButton meg){
        currentPokemon = 2;
        if(fireLvl >= 36){
            x.setImageResource(R.drawable.charizard);
            sp.setText(R.string.fire3);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.charizard);
            mp.start();
        }
        else if(fireLvl >= 16){
            x.setImageResource(R.drawable.charmeleon);
            sp.setText(R.string.fire2);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.charmeleon);
            mp.start();
        }
        else{
            x.setImageResource(R.drawable.charmander);
            sp.setText(R.string.fire1);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.charmander);
            mp.start();
        }
        meg.setImageResource(R.drawable.fire);
    }

    //opens Squirtle's Poké Ball
    public void chooseWater(ImageButton x, TextView sp, ImageButton meg){
        currentPokemon = 3;
        if(waterLvl >= 36){
            x.setImageResource(R.drawable.blastoise);
            sp.setText(R.string.water3);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.blastoise);
            mp.start();
        }
        else if(waterLvl >= 16){
            x.setImageResource(R.drawable.wartortle);
            sp.setText(R.string.water2);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.wartortle);
            mp.start();
        }
        else{
            x.setImageResource(R.drawable.squirtle);
            sp.setText(R.string.water1);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.squirtle);
            mp.start();
        }
        meg.setImageResource(R.drawable.water);
    }

    //opens Houndour's Poké Ball
    public void chooseDark(ImageButton x, TextView sp, ImageButton meg){
        currentPokemon = 4;
        if(darkLvl >= 24){
            x.setImageResource(R.drawable.houndoom);
            sp.setText(R.string.dark2);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.houndoom);
            mp.start();
        }
        else{
            x.setImageResource(R.drawable.houndour);
            sp.setText(R.string.dark1);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.houndour);
            mp.start();
        }
        meg.setImageResource(R.drawable.dark);
    }

    //puts Pokémon back into Poké Ball
    public void returnPokemon(ImageButton x, ImageButton y, TextView sp, TextView lv, ImageButton meg){
        x.setImageResource(R.drawable.substitute);
        y.setImageResource(R.drawable.candy2);
        sp.setText("???");
        lv.setText("LVL ???");
        meg.setImageResource(R.drawable.mega);
        currentPokemon = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
