# StratCon reference and FAQ (v2.6 - September 1, 2024).

## BASICS AND SETUP

**Double-check your Java version!**  You need 17 to play MHQ! This is a common source of issues. Check the discord for
detailed Java install instructions and general questions about the suite.  https://discord.gg/megamek

**If you don't have them, buy at least BattleMech Manual, or Total Warfare and Campaign Operations. PDF versions are
available online if you don't have the physical books.**

**Before you start StratCon, you should read the Official AtB TT Rules Excel spreadsheet "Campaign System" Tab and
CampaignAnon's Against the Bot Starter Guide PDF.** They are located in the docs' folder. StratCon is a an extra layer
on top of the AtB rules, and by learning those you will be learning the foundations of StratCon.

## Summary

StratCon is a system that simulates different theaters of operation on a planetary scale, broken down into "tracks" that
each have a different size and, perhaps, biomes, temperatures, and allied or enemy facilities. In practice, it generates
more random and less predictable circumstances that lead to a more dynamic, (and replayable) experience.

Different contract types have different scenario types. Different contract clauses have different command rights and
will greatly influence how allies and enemies are generated. Allies and Enemies can have different Skill and Equipment
Quality levels. Allied and Enemy Facilities can contribute certain positive and negative modifiers to each battle.
Random Positive and Negative modifiers can also be rolled for each battle. Most difficulty settings, including BV
percentage and number of Modifiers, are customizable on the AtB tab in Campaign Options.

### Note

These are the StratCon rules and they are often enforced by MHQ. However, there is a GM mode you can enable (top right
of the main screen) that allows you to cheat. You are your own GM and you can and should make edits to things you don't
like. Particularly, when you are learning. Good luck!

* To activate StratCon, go to the AtB tab in Campaign Options and check "Use StratCon" at the very bottom. You may have
  to scroll down some.
* At the same time on the same tab, you should change battle intensity. The StratCon version of MekHQ is meant to be
  played with battle intensity set to 0. Go to the Against the Bot tab in the campaign options and do this change. You
  can leave it as is, but you'll have all the regular AtB random battles spawning besides the StratCon ones.
* BV percentage and number of Modifiers are customizable here and will have an influence on difficulty.
* Most AtB scenario options in the Campaign Options have no longer have any effect when StratCon is enabled (namely:
  Chance of battle by role, double enemy vehicles, Allow enemy VTOL/aeros/turrets, Attached allied units control,
  DropShip use. You may ignore them).

## DIFFICULTY

StratCon will throw many curveballs at you and it can be challenging if you are just learning. However, you can adjust
the BV% difficulty and number of Modifiers allowed. If you want to tinker with difficulty, on the Against the Bot Tab:

### Skill Level

At regular ("classic") skill level you will the default 100% of enemy BV. You can change the OpFor base BV% by changing
the skill level. Anything above Veteran will be extremely hard:

| Skill       | % of BV |
|-------------|---------|
| Ultra-Green | 80%     |
| Green       | 90%     |
| Regular     | 100%    |
| Veteran     | 110%    |
| Elite       | 120%    |
| Heroic      | 130%    |
| Legendary   | 140%    |

### Modifiers

The default ("classic") modifier # is 3. That means you can randomly roll up to three modifiers per battle (in addition
to any added by facilities). Some modifiers are helpful to the player and some are adverse. They introduce variability
in the encounters, but some can be challenging if you happen to roll 3 adverse modifiers. You can change the maximum
number of modifiers to a number between 1-10 (in addition to facility modifiers). Less modifiers will reduce variety but
also should make it easier.

## QUICKSTART STEPS

- Start New Campaign
- Select a Preset (One of the StratCon presets).
- Select a Date
- Generate a Company (Manage Campaign, Company Generator, Generate)
- Find a Contract and accept it. (Marketplace, Contract Market)
- Travel to Contract (Briefing Tab, Click on Contract Planet, It will jump to Star Map, hit Calculate Jump Path, Begin
  Transit).
- Advance days while you travel to contract. Should hire spare personal and buy spare parts.
- When you land on a planet, go to the briefing tab, assign roles to your lances.
- Advance Days, Scout StratCon map on AtB Campaign State tab, complete Objectives, and fight.
- Try not to embarrass yourself.

## CONTRACT COMMAND RIGHTS & NOTES

### NOTE

Despite what is mentioned below, Relief-Duty, Garrison, and Cadre-Duty contracts always need to go their entire
duration.

### Integrated

You need to keep your VP count positive. Every time you win a scenario, that's +1 VP. Every time you lose a scenario, -1
VP. Your employer chooses and deploys your lance on missions. You cannot scout the map. You must complete the entire
duration of the contract. Allied officer(s) in a mek/ASF will go with you in scenarios. Try to keep them alive.

### House

You need to keep your VP count positive. Every time you win a scenario which you didn't initiate, that's +1 VP. Every
time you lose a scenario you didn't initiate, that's -1 VP. You choose which lance to deploy. You must complete the
entire duration of the contract. A House officer in a mek/ASF will go with you in scenarios. Try to keep them alive.

### Liaison

You need to keep your VP count positive, AND you're responsible for completing the given number of strategic objectives,
VPs are only affected by scenarios in which a liaison participates. You choose which lance to deploy. You must scout the
map to find objectives. Once all of your objectives are complete, you may end the contract early. A Liaison officer in a
mek/ASF will go with you in some scenarios. Try to keep them alive.

### Independent

only responsible for completing strategic objectives. Where, when, and who you deploy is up to you. Your final VP score
doesn't matter. You must scout the map to find objectives. Once all of your objectives are complete, you may end the
contract early.

## SCENARIOS IN STRATCON MODE

StratCon can now generate a substantially greater variety of terrain. A few highlights:

- Each track has an average temperature (based on average planetary temperature +/- 35)
- The track's temperature determines the available biomes (a cold track will have cold biomes, a hot track will have hot
  biomes)
- The biome of a hex on a track determines the map generator preset used to generate maps for that hex
- For the first time, map themes are used to give a distinct visual look to many of the maps
- Expect to see jungles, deserts, frozen wastelands, and many others
- Facilities can now spawn with reinforced buildings that are tough to destroy, so you might need to bring the big guns.

StratCon will generate scenarios based on the Contract. If such a scenario happens, it will be displayed in the Briefing
room AND the "AtB Campaign State" tab (as a red icon).

There are some "legacy" scenarios that are optional that dont appear on the StratCon map. Deploy to those from your
TO&E. Examples include Star League Cache, Civilian Help, Officer Duel, and Big Battle.

If a scenario appears only in the Briefing tab, then it's a legacy or special scenario (e.g. cache, big battle), and you
can ignore it if you wish (you would need to GM-remove it).

StratCon has "Tracks" that are basically map pages. When you are small, you will have one track (Track 0). As you grow,
your contract may involve multiple tracks. You switch tracks on the right side of the StratCon map in the track
dropdown.

Some scenarios and objectives may be on Track 0 and some on Track 1, etc. You need to make sure you check and scout all
the Tracks, as necessary.

You can also trigger scenario by scouting out the Track. See below.

StratCon scenarios can spawn Meks, vehicles, VTOLs, conventional infantry, battle armor, conventional fighters (with
bombs or missiles), AeroSpace Fighters (with even MORE bombs or missiles), Dropships (and hot drops), on and off-board
Artillery, and even wet navy units. Be prepared.

If you have even just a couple of Aerospace units, the game will spawn Aerospace or DropShip scenarios.

On most contracts, random VP-giving scenarios might pop-up, so you can lose or ignore some and still end up with a
positive balance.

Some Chase/Pursuit and similar scenarios might spawn with wrong deployment edges and OpFor with forced withdrawal
active regardless of being the attacker or defender. All this can be rectified in the Mega Mek lobby.

"My non-combat lance got dragged into battle!!" — The game sometimes ignores the non-combat flag (even for DropShips).
Just don't use non-combat flag with StratCon, as it'll cause issues.

"The Enemy has 80 units and I have 4!!" — StratCon normally pulls a lance/star unit from your TO&E to form as the seed
unit for a new scenario. BUT if you have units in your Main TO&E tree that are freestanding, it can pull those units as
seed, or it will use your whole TO&E BV as a seed. Common offenders are Dropships and Jumpships, etc. Make sure
everything under your TO&E is in a sub force. It might be best just to remove Dropships and Jumpships completely.

"The Enemy has 80 units and I have 4, again!!"  If you ever feel outnumbered or outmatched, assign your force to the
scenario, right click on it in the briefing tab, edit, and regenerate bot forces. It will tailor the new force to the
BV of your assigned force. You may still be outmatched (as sometimes that is intentional and it will require
reinforcements)—but it should be better.

Evacuate Scenario during a Garrison contract: If you lose the facility, it will be under enemy control. You can try to
attack and recapture it. If you dont, you will fail the contract. If there is a bug with this, you can right-click on
hex and GM add it again. If it's a contract objective, you have to restore it in the same hex.

Skipping scenarios.

Under integrated or house command, or if the liaison is coming along for the ride, you will lose a VP. Additionally, if
there's an allied facility on the track, the scenario will move towards the nearest allied facility. Sometimes, you need
to keep those intact as part of the contract. And if they get captured without a fight, the enemy will put them to use,
making later scenarios more difficult. Some scenarios might draw a bunch of modifiers and be challenging. There is no
shame in skipping a scenario if it is too hard. Make sure you win your other ones.

Don't delete a scenario with a deployed force. Many bugs involved. The best solution is to eat the VP loss, and add the
Victory Point through GM mode, if needed. Or, you can resolve it manually in MHQ, without a MUL file.

## YOUR MISSION AND GOALS IN STRATCON MODE

Your Contract Score is no longer the sole metric of your success.

Under Integrated and House command, you need to keep your VP count positive. Every time you win a scenario which you
didn't initiate, that's +1 VP. Every time you lose a scenario you didn't initiate, that's -1 VP.

Under Liaison command, you need to keep your VP count positive AND you're responsible for completing the given number
of strategic objectives. On defensive contracts, this may include keeping allied facilities intact and under allied
control. On offensive contracts, it's usually capturing/destroying facilities or winning specific scenarios. VPs are
only affected by scenarios in which a liaison participates.

Under Independent command, you're only responsible for completing strategic objectives.

StratCon contract VP's are only awarded for "required by employer" scenarios, and will show "deployment required by
contract / -1 VP if lost/ignored; +1 VP if won" and are NOT necessarily Contract Objectives. There is a screenshot
sticky in the StratCon channel for an example.

The information about whether a scenario gives VP/SP is stated in red on the scenario description in the StratCon tab.
"Scenario Victory Points" stated in the briefing tab are internal, meant for the game to find the effect (if any)of the
battle. So, VP discussed in a post-battle resolution screen and VP on the StratCon campaign tab are different. The ones
on the campaign tab are the only ones that count toward final contract score.

Orange objectives mean completed, but on-going objectives. Finished strategic objectives turn green.

## THE STRATCON HEX GRID

The hex grid represents the planet you're on. Each (up to) 8x8 section is a "Track."

Your "base", if you would have such a thing, is abstracted. It does not appear on the Track, though there might be
allied Strategic Objectives (places such as a supply or tank depot).

Unscouted hexes are shaded gray. Scouted hexes are light gray. If it is hard to tell, you can click on the hex and it
will say recon complete/recon incomplete.(See below how to scout)

Allied facilities are displayed as cyan icons. Hostile facilities as red icons. They provide the following Bonuses to
Allies or Enemies. Usually in the form of a modifier added to a battle. They will apply this modifier to a battle
approximately 60% of the time—EVEN IF YOU HAVE NOT FOUND THEM ON THE MAP YET. You should scout and take out hostile
bases quickly.

* Mek/Tank/Air/Arty base—Adds an allied or enemy reinforcement of the listed type to scenarios. Enemy bases of
  this type should be taken out quickly.
* Supply Depot - Allied = 1SP/week. Hostile = 5% bonus to Op for BV budget in scenarios.
* Data Center - Allied = Shows the entire Map. Hostile = Increase scenario odds and adds a enemy mek scout force to
  scenarios.
* Industrial Center - Allied = none. Hostile = Increases BV% and Equipment Quality of OpFor.
* Comms Center - adds a random positive modifier for the side that owns it.
* Early Warning Center - Reduces the number of turns for allied or enemy reinforcements to arrive during battle.
* Orbital Defense - Hostile = Prevents Aerospace and adds an enemy Officer mek to scenarios.
* Base of Operations - More and better defenders. Allied = losing this means a contract loss. Enemy = Adds enemy
  commander mek to scenarios. Enemy loss reduces contract activity.

Your forces currently deployed to the track are cyan icons.

Pending scenarios against hostile forces are red icons.

## HOW TO SCOUT

To send a Lance to scout, right click on an unscouted (dark gray) hex and select Manage then the Lance you want to send.
Scout-role Lances can scout out all surrounding hexes at once.

You can "cheat" by using GM Mode and right-clicking to reveal it all.

If your scouts find an Objective, this will immediately create a scenario, though it may be pending for a few days. Note
that the scouting itself may also create an encounter with hostiles that wouldn't exist otherwise.

Every time you send a Lance to scout or engage a scenario, it will be unavailable (including for repairs) for a duration
equal to the "Deployment Period" that's listed in the right pane. If you click on the relevant hex, the pane will show
return dates.

In theory, this should be the same for wounded warriors and salvaged units. As of 49.0, however, they teleport back to
base immediately.

### TIP

Because of their Role, scouts will trigger a lot of scenarios. You should have other fast-but-beefy lances (something
that moves at least 5/8) or Aerospace that can reinforce them when your scouts get in over their head. Because they
totally will.

## DEPLOYMENT IN STRATCON MODE

First, as of 49.0, the "Deployment Requirements" in the Briefing tab are not implemented in StratCon. However, the Lance
count is important, as you will get multiple scenarios, up to that lance count. Also the assigned Roles are crucial in
StratCon, as you will see below.

To deploy in StratCon mode, you must right-click on the relevant Track hex with nested red squares and Manage. Then you
can choose which Lance(s) to send, and what reinforcement to send. You can multi-select, and use ctrl-click to
unselect. (The "old" TO&E deployment tool still works, but is mostly kept for GM use; use the Campaign tab one instead.)

Note that when a Lance is deployed, you can right-click on that hex and click on a Lance's checkbox to have it remain in
that hex so that you don't have to spend resources to deploy it there later. Now you have a solid reason for having
spare Lances!

Note that when a Lance is deployed, or returning from a battle, you can't repair/resupply it. It is out in the field. So
you may not see meks in your repair bay to repair. Or units might appear in your TOE, but since they are still returning
from battle, they cant be deployed.

If under Integrated command, you don't get to choose! The command will choose for you... Otherwise, a Lance is randomly
auto-selected to compute the OpFor BV, and then you can change it. The exception is when you are scouting or voluntarily
creating a battle.

### To send reinforcements, you have several choices:

- You can spend a Support Point per Lance (or a Victory Point, in a pinch). SPs are obtained by certain scenarios or
  holding supply depot Objectives, and leftover Negotiation.
- If a Lance is already on the same hex as the scenario (likely because you've set it to remain there, see above), it
  can deploy for free.
- A lance in a 'fight' role can be deployed for free. However, on an 8 or less on a 2d6, it will add an extra negative
  modifier to the scenario. There will be feedback in the Activity Log.
- Fight role lances always consume VP/SP if available. Although game mechanics would imply a choice, it is not yet
  implemented. Forcing a roll is only possible if no VP/SP available, so you would have to remove them all via GM mode
  and re-add them after the roll. The bonus Parts gained cannot be removed at the moment, but if you go this route and
  want to keep game balance, you can always use them on low value items.
- If your primary Lance leader has leadership, and you have "auxiliary units" available (ones that are not of the same
  type as the main unit type of the primary force), you can deploy as many auxiliaries as you have leadership points.
  The BV of the extra units allowed by the lance commander's Leadership are limited to have lower BV than the lowest
  BV-valued unit of the deployed main force.
- If your primary lance is in a 'defend' role, you can deploy up to 2 * (x + 1) your lance leader's tactics skill in
  infantry, battle armor squads, and minefields. Any "leftover" defensive points are automatically converted into
  standard minefields.
- Otherwise, you can attempt to deploy a lance anyway. On a 2d6 roll, 2-5 means deployment failure, 6-8 adds extra
  negative modifier, 9 or more succeeds.

## A NOTE ON OPFOR GENERATION

The primary opposing forces are usually generated via the "scaled BV" method. This takes into account the difficulty
rating and your current CamOps or FMM unit rating. The algorithm is roughly as follows:

- Your unit rating determines the BV floor. This is a percentage from 50-100, inclusive.
- Your difficulty determines the BV ceiling. This percentage between 80-120, inclusive.

Multiply the above percentages by the BV of your primary force (the lance that gets somewhat-randomly selected when
the scenario is generated). The resulting BVs are the BV floor and BV ceiling, respectively. Note that, on
non-Integrated command, the primary force is a randomly picked lance from your TO&E, and you then get to choose which
lance is actually assigned to the fight.

1. The scaled OpFor receives one lance off the appropriate RAT. If the BV is under the floor, repeat.
2. If the BV is between the floor and ceiling, we roll a 1d100 and compare it to the ratio of current opposition BV /
   ceiling. If the roll is lower than the ratio, then we stop. Otherwise, go back to 1 and add another lance.

The intention here is that, as the unit gets better, it will face tougher opposition, while giving a bit of a break to
starting units. This mechanism may not produce very fair results for very low BV forces, so there is no expectation of a
balanced scenario for four squads of foot rifle infantry. For very high BV forces, you are likely to see excessive
numbers of hostile units. If you play in very early timelines (where RATs are not fully developed), or limit yourself to
certain units (like mostly tanks or mostly ASF) then you will likely find the difficulty varies wildly. Adjust

Modifiers can be randomly rolled or added to a scenario by a allied or enemy facility. Some modifiers are helpful. Some
are tough. Example 8 Pirate Aircraft or Overwhelming Enemy Ground Reinforcements can be challenging. Reinforce as
necessary, or take a loss. Pick your battles. Or if you want to cheat, start the battle and remove that force in the
MegaMek lobby. You can and will see enemy ASF, Artillery, and Infantry. You should probably invest in some of your own.

If the OpFor is too large, not present, not based on TO&E, unwinnable scenario: right-click scenario in the Briefing
Tab, "Edit", and click "Regenerate Bot Forces". The modifiers will be the same. The not-present OpFor issue might not be
solved this way. OpFor can also get higher BV, but you can always regenerate forces again.

## DESIGNING YOUR OWN SCENARIOS

Use the Scenario Template Editor to put together a scenario template. I recommend using the Briefing
Room → Add Scenario → Generate From Template mechanism to test the template out. Now, go to your
`data/scenariotemplates` directory and create (if it doesn't exist already) a file called `UserScenarioManifest.xml`. It
should be formatted exactly like `ScenarioManifest`. Make sure not to overlap with the ID numbers or file names in
`ScenarioManifest`, as that "may cause unpredictable behavior." Now that you've got your scenario in the
`UserScenarioManifest` file, it'll be added to the pool of scenarios StratCon draws from when generating battles.

If you think some scenarios are challenging and dont like them, you can delete them from the scenario manifest and they
will not spawn anymore. Make sure to save a backup copy of the scenario manifest before you change it.

## DESIGNING YOUR OWN MODIFIERS

Look in the scenario Now, go to your `data/scenariomodifiers` directory and create (if it doesn't exist already) a file
called `usermodifiermanifest.xml`. It should be formatted exactly like `modifiermanifest.xml`. Make sure not to overlap
with the ID numbers or file names in `ModifierManifest`, as that "may cause unpredictable behavior". Now that you've got
your scenario in the `UserModifierManifest` file, it'll be added to the pool of scenarios StratCon draws from when
generating battles.

### A note on Modifier Difficulty

The hardest Modifiers are Pirates Present Air & Ground and the Overwhelming Reinforcements. Each adds 8 or more enemy
units. Consider carefully before you add modifiers more challenging that these.

If you think some modifiers are challenging and dont like them, you can delete them from the modifier manifest and they
will not spawn anymore. Some modifiers are required by some scenarios. Deleting those may cause issues. Make sure to
save a backup copy of the scenario manifest before you change it.

## SPECIFIC STRATCON SCENARIO NOTES AND TRICKS

First, note that when there's several objectives listed in the second white box of a scenario write-out, it usually
means you have to complete one of those, not all. Also, they usually lead to different outcomes. This is detailed in the
post-op objective review, but not in the scenario statement.

Some scenario resolution logic is broken. A common example is needing to keep both 100% and 50% of a one-unit allied
force. One is deemed achieved, the other not, which might return the wrong results after battle. Another case is turret
status after battle. Change scenario resolution results accordingly and apply GM mode liberally if needed.

1) Leadership lets you bring extra auxiliary units for free (where an "auxiliary unit" is any unit of a different type
   than the majority of the lance and of lower BV than the lowest-BV unit in the lance) So: give your lance leaders
   leadership points, and keep some lower-BV units (tanks, aerospace fighters, whatever) around so you can bring extra
   stuff to a fight

   **NOTE:** This is bugged and your bonus unit may appear on other battles when it should not. You can save and reload
   MHQ after your battle with the bonus unit, and undeploy it as necessary after that and it wont appear on new battles
   after that.

2) Keep some lances on the "fight" role or keep some support/victory points. That way, if a fight seems unfair, you can
   bring an extra lance or two in.

3) On Independent and Liaison command rights, you're expected to complete the strategic objectives. On Liaison +
   command, you're expected to maintain a positive campaign VP.

4) If you have a lance on 'defend' role, keep some extra infantry/battle armor around, you can deploy those "for free"
   if that lance gets into a scenario (the number is dependent on lance leader tactics skill).

   **NOTE:** This is bugged and your bonus unit may appear on other battles when it should not. You can save and reload
   MHQ after your battle with the bonus unit, and undeploy it as necessary after that and it wont appear on new battles
   after that.

5) Take out or capture hostile facilities (especially "[unit type] base") ASAP, as they will add extra guaranteed lances
   of hostile reinforcements into a fight on that track. But if you can capture and hold them, then you get allied
   buddies coming in to help you instead.

6) Pay attention to scenario objectives—some scenarios you'll have an easier time with if you don't try to destroy
   everything. For example, the "pursuit" or "breakthrough" scenarios are best done at night with fast, jump-capable
   units (or hell, VTOLs). For facilities you're trying to take out, you can just destroy the turrets and bug out if you
   can't take the garrison.

### There's too many enemy reinforcements!

Might be a hostile facility or three on the track. Better do some recon and take them out, or, even better, capture
them so you can use them. Or, you might just be having bad luck - each scenario can receive up to three modifiers PLUS
modifiers added by facilities. You should deal with the facilities quickly.

### Ground control

By default, you control the terrain at the end if you've met the threshold to rout the enemy ground forces. On
scenarios where you have to flee the map, you do not, UNLESS you turn and destroy x% of the enemy.

### Disabling Turrets

There is no direct sure-fire way to go about disabling turrets. You have two choices:

- Shoot at the buildings and hope to get lucky. Each shot over the damage threshold can disable the turret's crew or
  weapon, which does the trick. However, your bot ally will likely keep firing at turret buildings... Also, setting
  turret buildings on fire may "help."
- Eliminate the stated % of the ground enemy forces. Once that's achieved, you're considered to have routed the forces
  and able to take control of the turrets.
- Some of the new facilities are built on Reinforced buildings that take a lot of damage to destroy. Make sure you pay
  attention to the map type and if there are heavy buildings you should bring some big guns.

### Base/objective attacks and capture

That one's a bit tricky.

- To capture the base you need to leave 75% of the turrets intact with 75% of op for destroyed. As explained above, your
  best bet is to NOT shoot at the turrets (though crew/weapon-disabled turrets count as preserved), then rout the
  indicated % of forces. That's tough if you have bot allies as they love to shoot and kick buildings; a trick is to
  give all allied bots all non-turret enemies as strategic targets and set their aggression level lower.
- To destroy the base, you need to destroy or disable ALL Turrets. You don't need to rout the ground forces.
- To recon the base, you need to scan all turrets. You might want to tweak allied bots as above. Jump jets are a must.
  Note that if you get a base Recon scenario, you're not bound to stick to recon and can still go for a capture or
  destroy. You might consider the scenario a failure, though, I guess.

### Scouting

Some scenarios ask you to spot/attack a unit to scout it out. Remember that MHQ will not keep a tally for you. So, make
sure to make a list first and check those you've so spotted.

### Fleeing units

MHQ considers all fled units as withdrawn, even if they fled when meant as part of their bot routine. In scenarios
where you must destroy a unit (e.g. assassinate or convoy attack) you should manually take note of units that have
actually fled and those that were destroyed and double-check upon scenario end.
