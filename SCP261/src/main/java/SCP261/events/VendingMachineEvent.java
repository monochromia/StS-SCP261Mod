package SCP261.events;

import SCP261.SCP261Mod;
import SCP261.potions.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import com.megacrit.cardcrawl.helpers.PotionHelper;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.random.Random;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase;

import java.util.ArrayList;

public class VendingMachineEvent extends AbstractImageEvent {

    public static final String ID = SCP261Mod.makeID("VendingMachineEvent");
    private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);
    private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;
    private static final String[] OPTIONS = eventStrings.OPTIONS;
    private static final String NAME = eventStrings.NAME;
    private static final String IMG = SCP261Mod.makeEventPath("261.png");

    private int[] costs = {30, 60, 90};
    AbstractPlayer p = AbstractDungeon.player;

    public VendingMachineEvent() {
        super(NAME, DESCRIPTIONS[0], IMG);
        this.noCardsInRewards = true;
        this.imageEventText.setDialogOption(OPTIONS[0] + costs[0] + OPTIONS[3]);
        this.imageEventText.setDialogOption(OPTIONS[1] + costs[1] + OPTIONS[3]);
        this.imageEventText.setDialogOption(OPTIONS[2] + costs[2] + OPTIONS[3]);
        this.imageEventText.setDialogOption(OPTIONS[4]);

        AbstractDungeon.getCurrRoom().rewards.clear();
    }

    @Override
    protected void buttonEffect(int buttonPressed) {
        int g = p.gold;
        switch (buttonPressed) {
           case 0:
               if(g >= costs[0]) {
                   AbstractDungeon.player.loseGold(costs[0]);
                   AbstractDungeon.getCurrRoom().rewards.clear();
                   AbstractDungeon.getCurrRoom().rewards.add(new RewardItem(GetRandomPotionByRarity(1)));
                   AbstractDungeon.combatRewardScreen.open();
               }
               else
               {
                   this.imageEventText.updateBodyText(DESCRIPTIONS[2]);
               }
               break;
           case 1:
               if(g >= costs[1]) {
                   AbstractDungeon.player.loseGold(costs[1]);
                   AbstractDungeon.getCurrRoom().rewards.clear();
                   AbstractDungeon.getCurrRoom().rewards.add(new RewardItem(GetRandomPotionByRarity(2)));
                   AbstractDungeon.combatRewardScreen.open();
               }
               else
               {
                   this.imageEventText.updateBodyText(DESCRIPTIONS[2]);
               }
               break;
           case 2:
               if(g >= costs[2]) {
                   AbstractDungeon.player.loseGold(costs[2]);
                   AbstractDungeon.getCurrRoom().rewards.clear();
                   AbstractDungeon.getCurrRoom().rewards.add(new RewardItem(GetRandomPotionByRarity(4)));
                   AbstractDungeon.combatRewardScreen.open();
               }
               else
               {
                   this.imageEventText.updateBodyText(DESCRIPTIONS[2]);
               }
               break;
           case 3:
               AbstractDungeon.getCurrRoom().phase = RoomPhase.COMPLETE;
               this.imageEventText.updateBodyText(DESCRIPTIONS[1]);
               this.imageEventText.clearAllDialogs();
               openMap();
               break;
           default:
               break;
        }
    }

    public AbstractPotion GetRandomPotionByRarity(int rarity)
    {
        Random rng = new Random();
        ArrayList<AbstractPotion> list = new ArrayList<AbstractPotion>();
        switch (rarity)
        {
            case 1:
            {
                list = PotionHelper.getPotionsByRarity(AbstractPotion.PotionRarity.COMMON);
                break;
            }
            case 2:
            {
                list = PotionHelper.getPotionsByRarity(AbstractPotion.PotionRarity.UNCOMMON);
                break;
            }
            case 3:
            {
                list = PotionHelper.getPotionsByRarity(AbstractPotion.PotionRarity.RARE);
                break;
            }
            case 4:
            {
                list.add(new AppleJuicePotion());
                list.add(new BarrettColaPotion());
                list.add(new BlastolaColaPotion());
                list.add(new BostonMolassesPotion());
                list.add(new ClockworkPotion());
                list.add(new DewritoBlazePotion());
                list.add(new DietGhostPotion());
                list.add(new EnergyGasPotion());
                list.add(new GirlTearsPotion());
                //list.add(new LaffertyPotion());
                list.add(new PenguinPunchPotion());
                list.add(new SweetSwarmPotion());
                list.add(new ThunderBarPotion());
                break;
            }
            default:
                list = null;
                break;
        }
        String randomKey = list.get(rng.random(list.size() - 1)).ID;
        return PotionHelper.getPotion(randomKey);
    }
}
