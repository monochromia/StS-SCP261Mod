package SCP261.relics;

import SCP261.SCP261Mod;
import SCP261.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.cards.colorless.*;
import com.megacrit.cardcrawl.cards.curses.Decay;
import com.megacrit.cardcrawl.cards.curses.Pain;
import com.megacrit.cardcrawl.cards.curses.Regret;
import com.megacrit.cardcrawl.cards.green.*;
import com.megacrit.cardcrawl.cards.purple.*;
import com.megacrit.cardcrawl.cards.red.*;
import com.megacrit.cardcrawl.cards.tempCards.Insight;
import com.megacrit.cardcrawl.cards.tempCards.ThroughViolence;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static SCP261.SCP261Mod.*;

public class SadistsTumblerRelic extends CustomRelic {
    public static final String ID = SCP261Mod.makeID("SadistsTumblerRelic");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("str.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("str.png"));

    public String[] TASTE() {
        return new String[]{
                "Mouthwatering",
                "Smooth",
                "Potent",
                "Dark",
                "Sharp",
                "Plain",
                "Energizing",
                "Cloudy",
                "Bitter",
                "Soft",
                "Lingering",
                "Divine",
                "Grainy",
                "Elegant",
                "Invigorating",
                "Volatile",
                "Fiery",
                "Punchy",
                "Runny",
                "Bland",
                "Livening",
                "Gritty",
                "Subtle",
                "Light",
                "Thoughtful",
                "Infuriating",
                "Teary",
                "Hot",
                "Numbing",
                "Vintage",
                "Metallic",
                "Powerful",
                "Unfocused",
                "Experimental",
                "Relaxing",
                "Rich",
                "Filling",
                "Vinegary",
                "Smoky",
                "Spicy",
                "Corked",
                "Fizzy",
                "Viscous",
                "Disgusting",
                "Tasteless",
                "Perfumed",
                "Salty",
                "Shocking",
                "Inedible",
                "Soothing",
                "Balanced",
                "Rotten",
                "Acidic",
                "Big",
                "Refreshing",
                "Unholy",
                "Frigid",
                "Breathtaking",
                "Overwhelming",
                "Sanguine",
                "Crystalline",
                "Neutral",
                "Alkaline",
                "Inventive",
        };
    }
    private String[] tastes = TASTE();

    public SadistsTumblerRelic() {
        super(ID, IMG, OUTLINE, RelicTier.SHOP, LandingSound.CLINK);
    }


    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new SadistsTumblerRelic();
    }

    @Override
    public int getPrice() {
        return 175;
    }

    @Override
    public void onEquip() {
        logger.info("Equipped Sadist's Tumbler");
    }

    @Override
    public void onUnequip() {
    }

    public void receivePostPotionUse(AbstractPotion ap) {
        logger.info("Sadist's Tumbler: Received PostPotionUse");
        AbstractCard c;
        String taste;
        switch (ap.ID) {
            case "BloodPotion":
                c = new Reaper();
                taste = tastes[0];
                break;
            case "ElixirPotion":
            case "Elixir":
                c = new Combust();
                taste = tastes[1];
                break;
            case "HeartOfIron":
                c = new Ragnarok();
                taste = tastes[2];
                break;
            case "Poison Potion":
                c = new Bane();
                taste = tastes[3];
                break;
            case "CunningPotion":
                c = new DieDieDie();
                taste = tastes[4];
                break;
            case "GhostInAJar":
                c = new EmptyFist();
                taste = tastes[5];
                break;
            case "FocusPotion":
            case "SCP261:ThunderBarPotion":
                c = new ConserveBattery();
                taste = tastes[6];
                break;
            case "PotionOfCapacity":
                c = new SteamBarrier();
                taste = tastes[7];
                break;
            case "EssenceOfDarkness":
                c = new Fasting();
                taste = tastes[8];
                break;
            case "BottledMiracle":
            case "jedi:specialdeliverypotion":
                c = new Sanctity();
                taste = tastes[9];
                break;
            case "StancePotion":
                c = new Perseverance();
                taste = tastes[10];
                break;
            case "Ambrosia":
                c = new Apotheosis();
                taste = tastes[11];
                break;
            case "Block Potion":
                c = new SandsOfTime();
                taste = tastes[12];
                break;
            case "Dexterity Potion":
                c = new Acrobatics();
                taste = tastes[13];
                break;
            case "Energy Potion":
                c = new Warcry();
                taste = tastes[14];
                break;
            case "Explosive Potion":
                c = new TheBomb();
                taste = tastes[15];
                break;
            case "Fire Potion":
                c = new FiendFire();
                taste = tastes[16];
                break;
            case "Strength Potion":
                c = new Uppercut();
                taste = tastes[17];
                break;
            case "Swift Potion":
                c = new FTL();
                taste = tastes[18];
                break;
            case "Weak Potion":
                c = new EmptyBody();
                taste = tastes[19];
                break;
            case "FearPotion":
            case "SCP261:EnergyGasPotion":
                c = new Adrenaline();
                taste = tastes[20];
                break;
            case "AttackPotion":
                c = new TrueGrit();
                taste = tastes[21];
                break;
            case "SkillPotion":
                c = new SneakyStrike();
                taste = tastes[22];
                break;
            case "PowerPotion":
                c = new Leap();
                taste = tastes[23];
                break;
            case "ColorlessPotion":
                c = new Insight();
                taste = tastes[24];
                break;
            case "SteroidPotion":
                c = new Anger();
                taste = tastes[25];
                break;
            case "SpeedPotion":
                c = new Blur();
                taste = tastes[26];
                break;
            case "BlessingOfTheForge":
                c = new BurningPact();
                taste = tastes[27];
                break;
            case "Regen Potion":
                c = new FeelNoPain();
                taste = tastes[28];
                break;
            case "Ancient Potion":
                c = new Discovery();
                taste = tastes[29];
                break;
            case "LiquidBronze":
            case "SCP261:ClockworkPotion":
                c = new Metallicize();
                taste = tastes[30];
                break;
            case "EssenceOfSteel":
                c = new Inflame();
                taste = tastes[31];
                break;
            case "DuplicationPotion":
                c = new Madness();
                taste = tastes[32];
                break;
            case "DistilledChaos":
                c = new Mayhem();
                taste = tastes[33];
                break;
            case "stsjorbsmod:LiquidClarity":
            case "LiquidMemories":
            case "jedi:coolantleak":
                c = new DeepBreath();
                taste = tastes[34];
                break;
            case "CultistPotion":
                c = new HandOfGreed();
                taste = tastes[35];
                break;
            case "Fruit Juice":
                c = new Feed();
                taste = tastes[36];
                break;
            case "SmokeBomb":
                c = new NoxiousFumes();
                taste = tastes[38];
                break;

            //SCP261 Potions
            case "stsjorbsmod:BurningPotion":
            case "SCP261:AppleJuicePotion":
                c = new FireBreathing();
                taste = tastes[39];
                break;
            case "SCP261:BarrettColaPotion":
                c = new Corruption();
                taste = tastes[40];
                break;
            case "SCP261:BlastolaColaPotion":
            case "sagemod:Flight_Potion":
                c = new WhiteNoise();
                taste = tastes[41];
                break;
            case "Languid Potion":
            case "SCP261:BostonMolassesPotion":
                c = new DarkShackles();
                taste = tastes[42];
                break;
            case "SCP261:DewritoBlazePotion":
                c = new Regret();
                taste = tastes[43];
                break;
            case "SCP261:DietGhostPotion":
                c = new EmptyMind();
                taste = tastes[44];
                break;
            case "SCP261:GirlTearsPotion":
                c = new DeadlyPoison();
                taste = tastes[45];
                break;
            case "SCP261:PenguinPunchPotion":
            case "jedi:tentaclejuice":
            case "jedi:lessertentaclejuice":
                c = new Armaments();
                taste = tastes[46];
                break;
            case "SCP261:SweetSwarmPotion":
                c = new BallLightning();
                taste = tastes[47];
                break;

            //Crossover Potion Flavors
            //Infinite Spire
            case "infinitespire:BlackPotion":
                c = new Pain();
                taste = tastes[48];
                break;
            //The Jungle
            case "AntidotePotion":
            case "jedi:lesserholywater":
            case "jedi:holywater":
                c = new Panacea();
                taste = tastes[49];
                break;
            case "HauntedGourdPotion":
                c = new Dash();
                taste = tastes[50];
                break;
            case "JungleJuicePotion":
                c = new Decay();
                taste = tastes[51];
                break;

            case "SpyderVenomPotion":
            case "Venom Potion":
                taste = tastes[52];
                c = new PoisonedStab();

                break;
            case "TwistedElixir":
                c = new Impervious();
                taste = tastes[53];
                break;
            //Replay The Spire
            case "Adrenaline Potion":
            case "stsjorbsmod:LiquidVirtue":
                c = new BandageUp();
                taste = tastes[54];
                break;
            case "Cursed Concoction":
                c = new Exhume();
                taste = tastes[55];
                break;
            case "Milkshake":
            case "Doom Potion":
                c = new ColdSnap();
                taste = tastes[56];
                break;
            case "Death Potion":
                c = new Choke();
                taste = tastes[57];
                break;
            case "Flashbang":
                c = new ThroughViolence();
                taste = tastes[58];
                break;
            case "LifebloodPotion":
                c = new Bloodletting();
                taste = tastes[59];
                break;
            case "Reflective Coating":
                c = new AutoShields();
                taste = tastes[60];
                break;
            case "ReplayShieldPotion":
                c = new Neutralize();
                taste = tastes[61];
                break;
            case "Toxic Potion":
                c = new Catalyst();
                taste = tastes[62];
                break;
            //The Sage
            case "sagemod:Fata_Morgana":
                c = new JackOfAllTrades();
                taste = tastes[63];
                break;

            //Future Modded Potions...
//           case "Potion":
//           case "Potion":
//           case "Potion":
//           case "Potion":
//           case "Potion":
//           case "Potion":
//           case "Potion":
//           case "Potion":
//           case "Potion":
//           case "Potion":
//           case "Potion":
//           case "Potion":
            case "EntropicBrew":
            case "GamblersBrew":
            case "Snecko Oil":
            case "SneckoExtractPotion":
            default:
                c = new Alchemize();
                taste = tastes[37];
                break;
        }
        this.flash();
        if (c.costForTurn > 0) {
            c.cost = 0;
            c.costForTurn = 0;
            c.isCostModified = true;
        }
        this.addToBot(new TalkAction(true, taste, 1.0F, 1.5F));
        this.addToBot(new MakeTempCardInHandAction(c));
    }
}
