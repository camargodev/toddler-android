package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;

import static com.ihc.toddler.entity.Tier.SILVER;

public class FirstContentRead extends Award {
    public FirstContentRead() {
        super("Primeira Aula", "Parabéns! Você assistiu sua primeira aula.", SILVER);
    }
}
