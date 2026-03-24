package moteur.oracle.model.value;

/**
 * d'ou vient l'évènement
 */
public enum FocusEvenement {

    /**
     * A Remote Event means that something has
     * happened that your Character wasn’t present
     * for; they’re only learning about it now. This can
     * happen in many ways.
     * Maybe the Player Character encounters
     * the dead body of an NPC they met earlier in
     * the adventure, and the Remote Event is this
     * Character’s death, which the PC did not directly
     * witness. Or maybe the PC wanders into a tavern
     * and learns by word of mouth that the enemy
     * horde has advanced, destroying the next town
     * down the road.
     * Remote Events are a way of introducing new
     * twists into an adventure without the PC being
     * directly involved with them.
     */
    REMOTE_EVENT,
    /**
     * An existing Non-Player Character does
     * something that impacts the adventure. Roll on
     * the Characters List to see which NPC acts for
     * this Event.
     */
    NPC_ACTION,
    /**
     * A new Non-Player Character enters the
     * adventure. This new Character plays a role in
     * the current Scene and will likely be added to the
     * Characters List when the Scene is over.
     */
    INTRODUCE_NEW_NPC,
    /**
     * Threads are the goals and missions that the
     * Player Character is pursuing. This Random Event
     * brings the PC one step closer to resolving an open
     * Thread. Roll on the Threads List to see which
     * Thread the Event involves.
     */
    MOVE_TOWARD_THREAD,
    /**
     * While the previous Random Event helps the
     * Player Character get closer to resolving an open
     * Thread, this Event does the opposite: it represents a
     * new hurdle or setback that hinders the PC’s progress
     * toward closing a Thread. Roll on the Threads List
     * to see which Thread the Event involves.
     */
    MOVE_AWAY_FROM_THREAD,
    /**
     * This Random Event brings about the closure of
     * an open Thread. Roll on the Threads List to see
     * which Thread this involves.
     * Determining how the Thread is closed will
     * require interpretation, but whatever the Event is
     * it should either resolve the Thread or nullify it
     * somehow.
     */
    CLOSE_THREAD,
    /**
     * Something bad or good happens to a Player
     * Character or Non-Player Character, depending on
     * which result you got on the Event Focus Table.
     * If the Event calls for a PC, determine which
     * PC it is. If you’re playing solo with a single Player
     * Character then this Event is automatically about
     * them; if there is more than one Player Character,
     * then choose the one you would most expect this
     * Event to apply to.
     * If the Event calls for a Non-Player Character,
     * roll on the Characters List to determine which
     * Character it is.
     * Negative and Positive outcomes of this
     * Random Event can run a gamut of possibilities
     * depending on the Context of the adventure
     * and how you interpret the result. The Positive
     * or Negative Event can be something story-
     * shifting and important, or it can be something
     * minor, as long as you think it’s the most expected
     * interpretation of your results.
     */
    NPC_NEGATIVE,
    NPC_POSITIVE,
    PC_NEGATIVE,
    PC_POSITIVE,
    /**
     * Most of the Event Focus Table results give you
     * a clear indication of what the Event is about. NPC
     * Action means that an NPC does something; PC
     * Positive means whatever that happens is good for
     * the Player Character. Maybe a Thread is being
     * closed, or maybe a new NPC enters the adventure.
     * Whatever it is, its impact on the adventure is clear.
     * An Ambiguous Event, however, is purposefully
     * vague. It’s something that happens which is
     * neither harmful nor helpful, at least not initially.
     * An Ambiguous Event can be interpreted in
     * several different ways. Perhaps the Event is vague,
     * and you won’t know whether it’s good or bad
     * until you check it out.
     * This makes an Ambiguous Event an opportunity
     * to explore.
     * Or perhaps the Ambiguous Event is a new
     * element in your adventure that doesn’t make
     * sense now but might make sense later. If your
     * PC comes across a photo of several people while
     * exploring an empty house, is this photo a clue
     * related to what you’re searching for, or is it just a
     * random photo with no relevance to your mission?
     * Only time will tell.
     * Ambiguous Events can easily turn into
     * narrative foreshadowing. Maybe those animal
     * sounds your PC heard in the woods are the
     * passage of small creatures they’ll soon encounter.
     * Maybe that photo you found will come in
     * handy later when you run afoul of a ghost in the
     * house. Keep those ambiguous details in mind in
     * case they fit with future Context and help you
     * interpret later events.
     */
    AMBIGUOUS_EVENT,
    /**
     * Whatever is happening in the Scene right now
     * becomes the Focus for this Event. If the Random
     * Event was generated from a Fate Question
     * then use the Context of the Fate Question as
     * the Focus. If the Random Event was triggered
     * as a Scene Interrupt then the Event is directly
     * related to whatever is currently going on in your
     * adventure. A Random Event with a Focus of
     * Current Context takes whatever is going on and
     * adds a new layer to it.
     */
    CURRENT_CONTEXT

}