/**
 * Defines common Id Generator that use PostgreSQL sequences properly.
 * It uses a separate sequence for the chosen ID, as opposed to using a single sequence for all IDs;
 * the same result can be achieved by simply using {@code @GeneratedValue(strategy = GenerationType.IDENTITY)}, but
 * that way hibernate would use a sequence as an identity, which would decrease performance.
 * <p>
 * Generates a sequence for each entity "entityName_seq"
 */
@GenericGenerator(name = "SequencePerEntityGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = @Parameter(name = "prefer_sequence_per_entity", value = "true"))
package com.samkruglov.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;