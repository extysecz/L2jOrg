package org.l2j.gameserver.model.conditions;

import org.l2j.gameserver.engine.skill.api.Skill;
import org.l2j.gameserver.model.actor.Creature;
import org.l2j.gameserver.model.item.ItemTemplate;

/**
 * The Class ConditionLogicAnd.
 *
 * @author mkizub
 */
public class ConditionLogicAnd extends Condition {
    private static Condition[] _emptyConditions = new Condition[0];
    public Condition[] conditions = _emptyConditions;

    public ConditionLogicAnd(Condition... conditions) {
        this.conditions = conditions;
    }

    /**
     * Adds the.
     *
     * @param condition the condition
     */
    public void add(Condition condition) {
        if (condition == null) {
            return;
        }

        final int len = conditions.length;
        final Condition[] tmp = new Condition[len + 1];
        System.arraycopy(conditions, 0, tmp, 0, len);
        tmp[len] = condition;
        conditions = tmp;
    }


    @Override
    public boolean testImpl(Creature effector, Creature effected, Skill skill, ItemTemplate item) {
        for (Condition c : conditions) {
            if (!c.test(effector, effected, skill, item)) {
                return false;
            }
        }
        return true;
    }
}
