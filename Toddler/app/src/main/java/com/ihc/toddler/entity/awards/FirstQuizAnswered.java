package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;

import static com.ihc.toddler.entity.Tier.SILVER;

public class FirstQuizAnswered extends Award {
    public FirstQuizAnswered() {
        super("Primeiro Quiz", "Parabéns! Você respondeu seu primeiro quiz.", SILVER);
    }
}
