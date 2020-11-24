package resources;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Clase que carga todos los elementos gráficos del juego.
 * @author Edgar Rubio
 *
 */
public class Images {

	
	public static BufferedImage[] butstart;
	public static BufferedImage menuImage;
	public static BufferedImage[] Quit;
	public static BufferedImage[] Options;
	public static BufferedImage[] howToPlay;

	public static BufferedImage gameTitle;
	public static BufferedImage gamecredits;
	public static BufferedImage edgar;
	public static BufferedImage miriam;
	public static BufferedImage music;
	public static BufferedImage loading;
	public static BufferedImage confImage;
	public static BufferedImage instructionMenuImage;
	public static BufferedImage volume;
	public static BufferedImage resolution;
	public static BufferedImage pauseMenuImage;
	public static BufferedImage statsImage;
	public static BufferedImage battleInterface;
	public static BufferedImage gameover;
	public static BufferedImage boss_front;
	public static BufferedImage thanks;
	public static BufferedImage town1;
	public static BufferedImage town2;
	public static BufferedImage town3;
	public static BufferedImage town4;
	public static BufferedImage town5;
	public static BufferedImage town6;
	public static BufferedImage town7;
	public static BufferedImage town8;
	public static BufferedImage town9;
	public static BufferedImage town10;
	public static BufferedImage town11;
	public static BufferedImage town12;
	public static BufferedImage town13;
	public static BufferedImage town14;
	public static BufferedImage town15;
	public static BufferedImage town16;
	public static BufferedImage town17;
	public static BufferedImage town18;
	public static BufferedImage winning1;
	public static BufferedImage winning2;
	public static BufferedImage winning3;
	public static BufferedImage winning4;
	public static BufferedImage winning5;
	public static BufferedImage winning6;
	public static BufferedImage winning7;
	public static BufferedImage winning8;
	public static BufferedImage winning9;
	public static BufferedImage winning10;
	public static BufferedImage winning11;
	public static BufferedImage winning12;
	public static BufferedImage[] muted;
	public static BufferedImage[] veinticinco;
	public static BufferedImage[] cincuenta;
	public static BufferedImage[] setentaycinco;
	public static BufferedImage[] cien;
	public static BufferedImage[] novecientos;
	public static BufferedImage[] milOchenta;
	public static BufferedImage[] screen;
	public static BufferedImage[] apply;
	public static BufferedImage[] resume;
	public static BufferedImage[] back;
	public static BufferedImage[] exit;
	public static BufferedImage[] stats;
	public static BufferedImage[] def;
	public static BufferedImage[] attack;
	public static BufferedImage[] defend;
	public static BufferedImage[] skill;
	public static BufferedImage[] retry;
	
	public static BufferedImage[] player_front;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_back;
	public static BufferedImage[] player_idle;
	public static BufferedImage[] player_attack;
	public static BufferedImage[] player_attacked;
	public static BufferedImage[] player_defense;
	public static BufferedImage[] player_skill;
	public static BufferedImage[] player_heal;
	public static BufferedImage[] enemy1_front;
	public static BufferedImage[] enemy1_left;
	public static BufferedImage[] enemy1_right;
	public static BufferedImage[] enemy1_back;
	public static BufferedImage[] enemy1_idle;
	public static BufferedImage[] enemy1_attack;
	public static BufferedImage[] enemy1_attacked;
	public static BufferedImage[] enemy1_defense;
	public static BufferedImage[] enemy1_skill;
	public static BufferedImage[] enemy1_heal;
	public static BufferedImage[] enemy2_front;
	public static BufferedImage[] enemy2_left;
	public static BufferedImage[] enemy2_right;
	public static BufferedImage[] enemy2_back;
	public static BufferedImage[] enemy2_idle;
	public static BufferedImage[] enemy2_attack;
	public static BufferedImage[] enemy2_attacked;
	public static BufferedImage[] enemy2_defense;
	public static BufferedImage[] enemy2_skill;
	public static BufferedImage[] enemy2_heal;
	public static BufferedImage[] boss_idle;
	public static BufferedImage[] boss_attack;
	public static BufferedImage[] boss_attacked;
	public static BufferedImage[] boss_defense;
	public static BufferedImage[] boss_skill;
	public static BufferedImage[] boss_heal;
	
	public static BufferedImage overWorldMap;
	public static Image scaledOverWorld;
	public static BufferedImage caveMap;
	public static Image scaledCave;
	public static BufferedImage castleMap;
	public static Image scaledCastle;
	public static BufferedImage caveBackground;
	public static BufferedImage castleBackground;
	
	public Images() {

		butstart = new BufferedImage[3];
		Options = new BufferedImage[3];
		Quit = new BufferedImage[2];
		howToPlay = new BufferedImage[2];
		muted = new BufferedImage[2];
		veinticinco = new BufferedImage[2];
		cincuenta = new BufferedImage[2];
		setentaycinco = new BufferedImage[2];
		cien = new BufferedImage[2];
		novecientos = new BufferedImage[2];
		milOchenta = new BufferedImage[2];
		screen = new BufferedImage[2];
		apply = new BufferedImage[2];
		def = new BufferedImage[2];
		resume = new BufferedImage[2];
		back = new BufferedImage[2];
		stats = new BufferedImage[2];
		exit = new BufferedImage[2];
		attack = new BufferedImage[2];
		defend = new BufferedImage[2];
		skill = new BufferedImage[2];
		retry = new BufferedImage[2];
		
		player_front = new BufferedImage[10];
		player_right = new BufferedImage[10];
		player_left = new BufferedImage[10];
		player_back = new BufferedImage[10];
		player_idle = new BufferedImage[4];
		player_attack = new BufferedImage[10];
		player_attacked = new BufferedImage[12];
		player_defense = new BufferedImage[8];
		player_skill = new BufferedImage[23];
		player_heal = new BufferedImage[5];
		
		enemy1_front = new BufferedImage[10];
		enemy1_right = new BufferedImage[10];
		enemy1_left = new BufferedImage[10];
		enemy1_back = new BufferedImage[10];
		enemy1_idle = new BufferedImage[4];
		enemy1_attack = new BufferedImage[10];
		enemy1_attacked = new BufferedImage[12];
		enemy1_defense = new BufferedImage[8];
		enemy1_skill = new BufferedImage[14];
		enemy1_heal = new BufferedImage[6];
		
		enemy2_front = new BufferedImage[10];
		enemy2_right = new BufferedImage[10];
		enemy2_left = new BufferedImage[10];
		enemy2_back = new BufferedImage[10];
		enemy2_idle = new BufferedImage[4];
		enemy2_attack = new BufferedImage[9];
		enemy2_attacked = new BufferedImage[12];
		enemy2_defense = new BufferedImage[8];
		enemy2_skill = new BufferedImage[15];
		enemy2_heal = new BufferedImage[5];
		
		boss_idle = new BufferedImage[4];
		boss_attack = new BufferedImage[9];
		boss_attacked = new BufferedImage[12];
		boss_defense = new BufferedImage[8];
		boss_skill = new BufferedImage[22];
		boss_heal = new BufferedImage[5];

		try {
			
			gameTitle = ImageIO.read(getClass().getResourceAsStream("/menuResources/kingdom.png"));
			menuImage = ImageIO.read(getClass().getResourceAsStream("/menuResources/menu.png"));
			loading = ImageIO.read(getClass().getResourceAsStream("/menuResources/loading.png"));
			confImage = ImageIO.read(getClass().getResourceAsStream("/menuResources/opciones.png"));
			volume = ImageIO.read(getClass().getResourceAsStream("/menuResources/volume2.png"));
			resolution = ImageIO.read(getClass().getResourceAsStream("/menuResources/resolution2.png"));
			gamecredits = ImageIO.read(getClass().getResourceAsStream("/menuResources/credits.png"));
			instructionMenuImage = ImageIO.read(getClass().getResourceAsStream("/menuResources/instructionMenuImage.png"));
			pauseMenuImage = ImageIO.read(getClass().getResourceAsStream("/menuResources/pause.png"));
			statsImage = ImageIO.read(getClass().getResourceAsStream("/menuResources/statsbase.png"));
			caveBackground = ImageIO.read(getClass().getResourceAsStream("/backgrounds/cavebackground.png"));
			castleBackground = ImageIO.read(getClass().getResourceAsStream("/backgrounds/castleBackground.png"));
			battleInterface = ImageIO.read(getClass().getResourceAsStream("/battleResources/barra.png"));
			gameover = ImageIO.read(getClass().getResourceAsStream("/menuResources/gameover.png"));
			edgar = ImageIO.read(getClass().getResourceAsStream("/menuResources/edgar.png"));
			miriam = ImageIO.read(getClass().getResourceAsStream("/menuResources/miriam.png"));
			music = ImageIO.read(getClass().getResourceAsStream("/menuResources/MUSIC.png"));
			thanks = ImageIO.read(getClass().getResourceAsStream("/menuResources/THANKS.png"));
			
			town1 = ImageIO.read(getClass().getResourceAsStream("/town/1.png"));
			town2 = ImageIO.read(getClass().getResourceAsStream("/town/2.png"));
			town3 = ImageIO.read(getClass().getResourceAsStream("/town/3.png"));
			town4 = ImageIO.read(getClass().getResourceAsStream("/town/4.png"));
			town5 = ImageIO.read(getClass().getResourceAsStream("/town/5.png"));
			town6 = ImageIO.read(getClass().getResourceAsStream("/town/6.png"));
			town7 = ImageIO.read(getClass().getResourceAsStream("/town/7.png"));
			town8 = ImageIO.read(getClass().getResourceAsStream("/town/8.png"));
			town9 = ImageIO.read(getClass().getResourceAsStream("/town/9.png"));
			town10 = ImageIO.read(getClass().getResourceAsStream("/town/10.png"));
			town11 = ImageIO.read(getClass().getResourceAsStream("/town/11.png"));
			town12 = ImageIO.read(getClass().getResourceAsStream("/town/12.png"));
			town13 = ImageIO.read(getClass().getResourceAsStream("/town/13.png"));
			town14 = ImageIO.read(getClass().getResourceAsStream("/town/14.png"));
			town15 = ImageIO.read(getClass().getResourceAsStream("/town/15.png"));
			town16 = ImageIO.read(getClass().getResourceAsStream("/town/16.png"));
			town17 = ImageIO.read(getClass().getResourceAsStream("/town/17.png"));
			town18 = ImageIO.read(getClass().getResourceAsStream("/town/18.png"));
			
			winning1 = ImageIO.read(getClass().getResourceAsStream("/winning/1.png"));
			winning2 = ImageIO.read(getClass().getResourceAsStream("/winning/2.png"));
			winning3 = ImageIO.read(getClass().getResourceAsStream("/winning/3.png"));
			winning4 = ImageIO.read(getClass().getResourceAsStream("/winning/4.png"));
			winning5 = ImageIO.read(getClass().getResourceAsStream("/winning/5.png"));
			winning6 = ImageIO.read(getClass().getResourceAsStream("/winning/6.png"));
			winning7 = ImageIO.read(getClass().getResourceAsStream("/winning/7.png"));
			winning8 = ImageIO.read(getClass().getResourceAsStream("/winning/8.png"));
			winning9 = ImageIO.read(getClass().getResourceAsStream("/winning/9.png"));
			winning10 = ImageIO.read(getClass().getResourceAsStream("/winning/10.png"));
			winning11 = ImageIO.read(getClass().getResourceAsStream("/winning/11.png"));
			winning12 = ImageIO.read(getClass().getResourceAsStream("/winning/12.png"));
			
			overWorldMap = ImageIO.read(getClass().getResourceAsStream("/maps/overWorld.png"));
			scaledOverWorld = Images.overWorldMap.getScaledInstance(3680, 2000, Image.SCALE_SMOOTH); // 368x400 pixeles
			caveMap = ImageIO.read(getClass().getResourceAsStream("/maps/CaveMap.png"));
			scaledCave = Images.caveMap.getScaledInstance(3680, 4000, Image.SCALE_SMOOTH); // 368x400 pixeles
			castleMap = ImageIO.read(getClass().getResourceAsStream("/maps/castle.png"));
			scaledCastle = Images.castleMap.getScaledInstance(3680, 4000, Image.SCALE_SMOOTH); // 368x400 pixeles
			
			Options[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/options2.png"));
			Options[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/options.png"));
			butstart[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/start2.png"));
			butstart[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/start.png"));
			Quit[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/quit2.png"));
			Quit[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/quit.png"));
			howToPlay[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/howtoplay2.png"));
			howToPlay[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/howtoplay.png"));
			muted[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/mute2.png"));
			muted[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/mute.png"));
			veinticinco[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/25-2.png"));
			veinticinco[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/25.png"));
			cincuenta[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/50-2.png"));
			cincuenta[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/50.png"));
			setentaycinco[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/75-2.png"));
			setentaycinco[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/75.png"));
			cien[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/100-2.png"));
			cien[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/100.png"));
			novecientos[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/1600-2.png"));
			novecientos[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/1600.png"));
			milOchenta[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/1920-2.png"));
			milOchenta[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/1920.png"));
			screen[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/screenRes2.png"));
			screen[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/screenRes.png"));
			apply[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/apply2.png"));
			apply[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/apply.png"));
			def[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/default2.png"));
			def[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/default.png"));
			resume[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/resume2.png"));
			resume[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/resume.png"));
			back[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/back2.png"));
			back[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/back.png"));
			stats[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/stats2.png"));
			stats[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/stats.png"));
			exit[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/exit2.png"));
			exit[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/exit.png"));
			attack[1] = ImageIO.read(getClass().getResourceAsStream("/battleResources/attack2.png"));
			attack[0] = ImageIO.read(getClass().getResourceAsStream("/battleResources/attack.png"));
			defend[1] = ImageIO.read(getClass().getResourceAsStream("/battleResources/defend2.png"));
			defend[0] = ImageIO.read(getClass().getResourceAsStream("/battleResources/defend.png"));
			skill[1] = ImageIO.read(getClass().getResourceAsStream("/battleResources/skill2.png"));
			skill[0] = ImageIO.read(getClass().getResourceAsStream("/battleResources/skill.png"));
			retry[1] = ImageIO.read(getClass().getResourceAsStream("/menuResources/retry2.png"));
			retry[0] = ImageIO.read(getClass().getResourceAsStream("/menuResources/retry.png"));
			
			player_front[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/1.png"));
			player_front[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/2.png"));
			player_front[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/3.png"));
			player_front[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/4.png"));
			player_front[4] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/5.png"));
			player_front[5] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/6.png"));
			player_front[6] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/7.png"));
			player_front[7] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/8.png"));
			player_front[8] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/9.png"));
			player_front[9] = ImageIO.read(getClass().getResourceAsStream("/characters/player/front/10.png"));
			
			player_left[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/1.png"));
			player_left[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/2.png"));
			player_left[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/3.png"));
			player_left[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/4.png"));
			player_left[4] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/5.png"));
			player_left[5] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/6.png"));
			player_left[6] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/7.png"));
			player_left[7] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/8.png"));
			player_left[8] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/9.png"));
			player_left[9] = ImageIO.read(getClass().getResourceAsStream("/characters/player/left/10.png"));
			
			player_back[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/1.png"));
			player_back[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/2.png"));
			player_back[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/3.png"));
			player_back[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/4.png"));
			player_back[4] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/5.png"));
			player_back[5] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/6.png"));
			player_back[6] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/7.png"));
			player_back[7] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/8.png"));
			player_back[8] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/9.png"));
			player_back[9] = ImageIO.read(getClass().getResourceAsStream("/characters/player/back/10.png"));
			
			player_right[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/1.png"));
			player_right[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/2.png"));
			player_right[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/3.png"));
			player_right[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/4.png"));
			player_right[4] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/5.png"));
			player_right[5] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/6.png"));
			player_right[6] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/7.png"));
			player_right[7] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/8.png"));
			player_right[8] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/9.png"));
			player_right[9] = ImageIO.read(getClass().getResourceAsStream("/characters/player/right/10.png"));
			
			player_attack[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/1.png"));
			player_attack[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/2.png"));
			player_attack[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/3.png"));
			player_attack[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/4.png"));
			player_attack[4] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/5.png"));
			player_attack[5] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/6.png"));
			player_attack[6] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/7.png"));
			player_attack[7] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/8.png"));
			player_attack[8] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/9.png"));
			player_attack[9] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attack/10.png"));
			
			player_attacked[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/1.png"));
			player_attacked[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/2.png"));
			player_attacked[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/3.png"));
			player_attacked[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/4.png"));
			player_attacked[4] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/5.png"));
			player_attacked[5] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/6.png"));
			player_attacked[6] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/7.png"));
			player_attacked[7] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/8.png"));
			player_attacked[8] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/9.png"));
			player_attacked[9] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/10.png"));
			player_attacked[10] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/11.png"));
			player_attacked[11] = ImageIO.read(getClass().getResourceAsStream("/characters/player/attacked/12.png"));
			
			player_defense[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/defense/1.png"));
			player_defense[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/defense/2.png"));
			player_defense[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/defense/3.png"));
			player_defense[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/defense/4.png"));
			player_defense[4] = ImageIO.read(getClass().getResourceAsStream("/characters/player/defense/5.png"));
			player_defense[5] = ImageIO.read(getClass().getResourceAsStream("/characters/player/defense/6.png"));
			player_defense[6] = ImageIO.read(getClass().getResourceAsStream("/characters/player/defense/7.png"));
			player_defense[7] = ImageIO.read(getClass().getResourceAsStream("/characters/player/defense/8.png"));
			
			player_skill[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/1.png"));
			player_skill[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/2.png"));
			player_skill[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/3.png"));
			player_skill[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/4.png"));
			player_skill[4] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/5.png"));
			player_skill[5] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/6.png"));
			player_skill[6] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/7.png"));
			player_skill[7] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/8.png"));
			player_skill[8] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/9.png"));
			player_skill[9] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/10.png"));
			player_skill[10] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/11.png"));
			player_skill[11] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/12.png"));
			player_skill[12] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/13.png"));
			player_skill[13] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/14.png"));
			player_skill[14] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/15.png"));
			player_skill[15] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/16.png"));
			player_skill[16] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/17.png"));
			player_skill[17] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/18.png"));
			player_skill[18] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/19.png"));
			player_skill[19] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/20.png"));
			player_skill[20] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/21.png"));
			player_skill[21] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/22.png"));
			player_skill[22] = ImageIO.read(getClass().getResourceAsStream("/characters/player/skill/23.png"));

			player_heal[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/heal/1.png"));
			player_heal[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/heal/2.png"));
			player_heal[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/heal/3.png"));
			player_heal[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/heal/4.png"));
			player_heal[4] = ImageIO.read(getClass().getResourceAsStream("/characters/player/heal/5.png"));
			
			player_idle[0] = ImageIO.read(getClass().getResourceAsStream("/characters/player/idle/1.png"));
			player_idle[1] = ImageIO.read(getClass().getResourceAsStream("/characters/player/idle/2.png"));
			player_idle[2] = ImageIO.read(getClass().getResourceAsStream("/characters/player/idle/3.png"));
			player_idle[3] = ImageIO.read(getClass().getResourceAsStream("/characters/player/idle/4.png"));
			
			enemy1_front[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/1.png"));
			enemy1_front[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/2.png"));
			enemy1_front[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/3.png"));
			enemy1_front[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/4.png"));
			enemy1_front[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/5.png"));
			enemy1_front[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/6.png"));
			enemy1_front[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/7.png"));
			enemy1_front[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/8.png"));
			enemy1_front[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/9.png"));
			enemy1_front[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/front/10.png"));
			
			enemy1_left[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/1.png"));
			enemy1_left[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/2.png"));
			enemy1_left[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/3.png"));
			enemy1_left[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/4.png"));
			enemy1_left[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/5.png"));
			enemy1_left[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/6.png"));
			enemy1_left[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/7.png"));
			enemy1_left[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/8.png"));
			enemy1_left[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/9.png"));
			enemy1_left[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/left/10.png"));
			
			enemy1_back[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/1.png"));
			enemy1_back[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/2.png"));
			enemy1_back[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/3.png"));
			enemy1_back[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/4.png"));
			enemy1_back[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/5.png"));
			enemy1_back[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/6.png"));
			enemy1_back[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/7.png"));
			enemy1_back[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/8.png"));
			enemy1_back[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/9.png"));
			enemy1_back[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/back/10.png"));
			
			enemy1_right[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/1.png"));
			enemy1_right[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/2.png"));
			enemy1_right[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/3.png"));
			enemy1_right[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/4.png"));
			enemy1_right[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/5.png"));
			enemy1_right[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/6.png"));
			enemy1_right[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/7.png"));
			enemy1_right[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/8.png"));
			enemy1_right[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/9.png"));
			enemy1_right[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/right/10.png"));
			
			enemy1_defense[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/defense/1.png"));
			enemy1_defense[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/defense/2.png"));
			enemy1_defense[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/defense/3.png"));
			enemy1_defense[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/defense/4.png"));
			enemy1_defense[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/defense/5.png"));
			enemy1_defense[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/defense/6.png"));
			enemy1_defense[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/defense/7.png"));
			enemy1_defense[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/defense/8.png"));
			
			enemy1_idle[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/idle/1.png"));
			enemy1_idle[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/idle/2.png"));
			enemy1_idle[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/idle/3.png"));
			enemy1_idle[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/idle/4.png"));
			
			enemy1_attack[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/1.png"));
			enemy1_attack[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/2.png"));
			enemy1_attack[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/3.png"));
			enemy1_attack[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/4.png"));
			enemy1_attack[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/5.png"));
			enemy1_attack[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/6.png"));
			enemy1_attack[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/7.png"));
			enemy1_attack[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/8.png"));
			enemy1_attack[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/9.png"));
			enemy1_attack[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attack/10.png"));
			
			enemy1_attacked[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/1.png"));
			enemy1_attacked[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/2.png"));
			enemy1_attacked[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/3.png"));
			enemy1_attacked[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/4.png"));
			enemy1_attacked[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/5.png"));
			enemy1_attacked[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/6.png"));
			enemy1_attacked[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/7.png"));
			enemy1_attacked[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/8.png"));
			enemy1_attacked[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/9.png"));
			enemy1_attacked[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/10.png"));
			enemy1_attacked[10] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/11.png"));
			enemy1_attacked[11] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/attacked/12.png"));
			
			enemy1_skill[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/1.png"));
			enemy1_skill[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/2.png"));
			enemy1_skill[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/3.png"));
			enemy1_skill[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/4.png"));
			enemy1_skill[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/5.png"));
			enemy1_skill[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/6.png"));
			enemy1_skill[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/7.png"));
			enemy1_skill[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/8.png"));
			enemy1_skill[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/9.png"));
			enemy1_skill[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/10.png"));
			enemy1_skill[10] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/11.png"));
			enemy1_skill[11] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/12.png"));
			enemy1_skill[12] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/13.png"));
			enemy1_skill[13] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/skill/14.png"));

			enemy1_heal[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/heal/1.png"));
			enemy1_heal[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/heal/1.png"));
			enemy1_heal[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/heal/2.png"));
			enemy1_heal[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/heal/3.png"));
			enemy1_heal[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/heal/4.png"));
			enemy1_heal[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy1/heal/5.png"));
			
			enemy2_front[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/1.png"));
			enemy2_front[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/2.png"));
			enemy2_front[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/3.png"));
			enemy2_front[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/4.png"));
			enemy2_front[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/5.png"));
			enemy2_front[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/6.png"));
			enemy2_front[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/7.png"));
			enemy2_front[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/8.png"));
			enemy2_front[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/9.png"));
			enemy2_front[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/front/10.png"));
			
			enemy2_left[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/1.png"));
			enemy2_left[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/2.png"));
			enemy2_left[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/3.png"));
			enemy2_left[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/4.png"));
			enemy2_left[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/5.png"));
			enemy2_left[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/6.png"));
			enemy2_left[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/7.png"));
			enemy2_left[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/8.png"));
			enemy2_left[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/9.png"));
			enemy2_left[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/left/10.png"));
			
			enemy2_back[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/1.png"));
			enemy2_back[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/2.png"));
			enemy2_back[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/3.png"));
			enemy2_back[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/4.png"));
			enemy2_back[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/5.png"));
			enemy2_back[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/6.png"));
			enemy2_back[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/7.png"));
			enemy2_back[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/8.png"));
			enemy2_back[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/9.png"));
			enemy2_back[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/back/10.png"));
			
			enemy2_right[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/1.png"));
			enemy2_right[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/2.png"));
			enemy2_right[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/3.png"));
			enemy2_right[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/4.png"));
			enemy2_right[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/5.png"));
			enemy2_right[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/6.png"));
			enemy2_right[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/7.png"));
			enemy2_right[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/8.png"));
			enemy2_right[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/9.png"));
			enemy2_right[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/right/10.png"));
			
			enemy2_idle[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/idle/1.png"));
			enemy2_idle[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/idle/2.png"));
			enemy2_idle[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/idle/3.png"));
			enemy2_idle[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/idle/4.png"));
			
			enemy2_attack[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attack/1.png"));
			enemy2_attack[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attack/2.png"));
			enemy2_attack[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attack/3.png"));
			enemy2_attack[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attack/4.png"));
			enemy2_attack[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attack/5.png"));
			enemy2_attack[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attack/6.png"));
			enemy2_attack[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attack/7.png"));
			enemy2_attack[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attack/8.png"));
			enemy2_attack[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attack/9.png"));
			
			enemy2_attacked[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/1.png"));
			enemy2_attacked[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/2.png"));
			enemy2_attacked[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/3.png"));
			enemy2_attacked[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/4.png"));
			enemy2_attacked[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/5.png"));
			enemy2_attacked[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/6.png"));
			enemy2_attacked[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/7.png"));
			enemy2_attacked[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/8.png"));
			enemy2_attacked[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/9.png"));
			enemy2_attacked[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/10.png"));
			enemy2_attacked[10] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/11.png"));
			enemy2_attacked[11] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/attacked/12.png"));
			
			enemy2_defense[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/defense/1.png"));
			enemy2_defense[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/defense/2.png"));
			enemy2_defense[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/defense/3.png"));
			enemy2_defense[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/defense/4.png"));
			enemy2_defense[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/defense/5.png"));
			enemy2_defense[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/defense/6.png"));
			enemy2_defense[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/defense/7.png"));
			enemy2_defense[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/defense/8.png"));
			
			enemy2_skill[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/1.png"));
			enemy2_skill[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/2.png"));
			enemy2_skill[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/3.png"));
			enemy2_skill[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/4.png"));
			enemy2_skill[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/5.png"));
			enemy2_skill[5] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/6.png"));
			enemy2_skill[6] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/7.png"));
			enemy2_skill[7] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/8.png"));
			enemy2_skill[8] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/9.png"));
			enemy2_skill[9] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/10.png"));
			enemy2_skill[10] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/11.png"));
			enemy2_skill[11] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/12.png"));
			enemy2_skill[12] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/13.png"));
			enemy2_skill[13] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/14.png"));
			enemy2_skill[14] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/skill/15.png"));

			enemy2_heal[0] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/heal/1.png"));
			enemy2_heal[1] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/heal/2.png"));
			enemy2_heal[2] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/heal/3.png"));
			enemy2_heal[3] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/heal/4.png"));
			enemy2_heal[4] = ImageIO.read(getClass().getResourceAsStream("/characters/enemy2/heal/5.png"));
			
			boss_idle[0] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/idle/1.png"));
			boss_idle[1] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/idle/2.png"));
			boss_idle[2] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/idle/3.png"));
			boss_idle[3] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/idle/4.png"));
			
			boss_attack[0] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attack/9.png"));
			boss_attack[1] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attack/10.png"));
			boss_attack[2] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attack/11.png"));
			boss_attack[3] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attack/12.png"));
			boss_attack[4] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attack/13.png"));
			boss_attack[5] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attack/14.png"));
			boss_attack[6] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attack/15.png"));
			boss_attack[7] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attack/16.png"));
			boss_attack[8] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attack/17.png"));
			
			boss_attacked[0] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/9.png"));
			boss_attacked[1] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/10.png"));
			boss_attacked[2] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/11.png"));
			boss_attacked[3] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/12.png"));
			boss_attacked[4] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/13.png"));
			boss_attacked[5] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/14.png"));
			boss_attacked[6] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/15.png"));
			boss_attacked[7] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/16.png"));
			boss_attacked[8] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/17.png"));
			boss_attacked[9] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/18.png"));
			boss_attacked[10] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/19.png"));
			boss_attacked[11] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/attacked/20.png"));
			
			boss_defense[0] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/defense/1.png"));
			boss_defense[1] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/defense/2.png"));
			boss_defense[2] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/defense/3.png"));
			boss_defense[3] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/defense/4.png"));
			boss_defense[4] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/defense/5.png"));
			boss_defense[5] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/defense/6.png"));
			boss_defense[6] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/defense/7.png"));
			boss_defense[7] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/defense/8.png"));
			
			boss_skill[0] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/9.png"));
			boss_skill[1] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/10.png"));
			boss_skill[2] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/11.png"));
			boss_skill[3] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/12.png"));
			boss_skill[4] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/13.png"));
			boss_skill[5] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/14.png"));
			boss_skill[6] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/15.png"));
			boss_skill[7] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/16.png"));
			boss_skill[8] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/17.png"));
			boss_skill[9] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/18.png"));
			boss_skill[10] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/19.png"));
			boss_skill[11] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/20.png"));
			boss_skill[12] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/21.png"));
			boss_skill[13] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/22.png"));
			boss_skill[14] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/23.png"));
			boss_skill[15] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/24.png"));
			boss_skill[16] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/25.png"));
			boss_skill[17] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/26.png"));
			boss_skill[18] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/27.png"));
			boss_skill[19] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/28.png"));
			boss_skill[20] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/29.png"));
			boss_skill[21] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/skill/30.png"));

			boss_heal[0] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/heal/1.png"));
			boss_heal[1] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/heal/2.png"));
			boss_heal[2] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/heal/3.png"));
			boss_heal[3] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/heal/4.png"));
			boss_heal[4] = ImageIO.read(getClass().getResourceAsStream("/characters/boss/heal/5.png"));
			
			boss_front = ImageIO.read(getClass().getResourceAsStream("/characters/boss/front/quieto.png"));
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
