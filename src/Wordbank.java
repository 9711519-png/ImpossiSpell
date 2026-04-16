pubic class WordBank {

  // Arrays for each difficulty
  private String [] easy;
  private String [] medium;
  private String [] hard;
  private String [] difficult;
  private String [] expert;
  private String [] insane;
  private String [] impossible;

  public Wordbank() {
    easy = new String[] {"cat", "dog", "sun", "hat", "tree",
    "book", "fish", "milk", "ball", "star",
    "rain", "bird", "shoe", "apple", "car",
    "house", "water", "grass", "smile", "jump",
    "chair", "table", "bread", "school", "light",
    "cloud", "flower", "cookie", "happy", "baby",
    "sleep", "family", "friend", "music", "color",
    "pencil", "window", "garden", "river", "beach",
    "snow", "summer", "winter", "candy", "story",
    "laugh", "world", "picture", "blanket", "morning"};
                        }
    medium = new string[] {
    "garden", "puzzle", "whisper", "silver", "window",
    "pencil", "planet", "river", "candle", "mountain",
    "shadow", "pocket", "thunder", "bridge", "forest",
    "travel", "danger", "sudden", "broken", "yellow",
    "moment", "blanket", "capture", "distant", "energy",
    "feather", "fortune", "gather", "holiday", "imagine",
    "journey", "lantern", "measure", "nervous", "orchard",
    "pattern", "quarter", "rescue", "shelter", "traffic",
    "uncover", "village", "wander", "weather", "wonder",
    "zebra", "border", "captain", "circus", "costume"
    };
    
    hard = new string[] {"silhouette", "pharaoh", "catastrophe", "chaos", "rhythm",
    "knuckle", "receipt", "island", "column", "vehicle",
    "oxygen", "jealous", "ancient", "banquet", "drought",
    "friction", "gesture", "harvest", "journal", "luggage",
    "musician", "nuisance", "obstacle", "pamphlet", "porcelain",
    "raspberry", "schedule", "subtle", "technique", "thorough",
    "tyranny", "vacuum", "warrior", "yacht", "zephyr",
    "adolescent", "ambiguous", "apparatus", "artisan", "auxiliary",
    "baroque", "bizarre", "boulevard", "camouflage", "celestial"};
    
    difficult = new string[] {"onomatopoeia", "bureaucracy", "camouflage", "entrepreneur", "miscellaneous",
    "conscience", "acquaintance", "parliament", "surveillance", "hemorrhage",
    "caribbean", "chandelier", "cataclysm", "renaissance", "silhouette",
    "quarantine", "phenomenon", "cathedral", "horizon", "magnificent",
    "accommodate", "annihilate", "archetype", "bellwether", "bourgeois",
    "camaraderie", "chrysanthemum", "cognizant", "commemorate", "connoisseur",
    "deceitful", "dilemma", "dissonance", "embellish", "euphemism",
    "facetious", "fallacious", "fluorescent", "gargantuan", "idiosyncrasy",
    "juxtapose", "kaleidoscope", "liaison", "maneuver", "nefarious"};
    
    expert = new String[] {"juxtaposition", "idiosyncratic", "perspicacious", "circumlocution", "magnanimous",
    "metamorphosis", "transcendental", "philosophical", "conscientious", "belligerent",
    "ambidextrous", "fortuitous", "gregarious", "hypothesis", "infrastructure",
    "preposterous", "quintessential", "rhetorical", "simultaneous", "vocabulary",
    "benevolent", "capricious", "carnivorous", "debilitate", "effervescent",
    "fastidious", "harmonious", "illegible", "judicious", "kinesthetic",
    "ludicrous", "meticulous", "notoriety", "opposition", "paradoxical",
    "quarantine", "repertoire", "sagacious", "tenacious", "ubiquitous",
    "voracious", "whimsical", "xenophobia", "yesteryear", "zealous",
    "articulate", "charismatic", "diligence", "eloquent", "formidable"};
                           
    insane = new String[] {"synecdoche", "schadenfreude", "apocryphal", "concatenation", "dodecahedron",
    "eschatology", "indefatigable", "lackadaisical", "lugubrious", "mnemonic",
    "obfuscation", "paraphernalia", "pusillanimous", "reconnaissance", "susceptible",
    "verisimilitude", "chiaroscurist", "flibbertigibbet", "antediluvian", "bourgeoisie",
    "cachinnation", "callipygian", "catawampus", "cerebellum", "contumacious",
    "defenestration", "dichotomy", "ebullient", "effulgent", "ephemeral",
    "grandiloquent", "hallucinogenic", "incontrovertible", "insouciance", "labyrinthine",
    "magniloquent", "mellifluous", "nebulous", "onomastic", "perspicuity",
    "quixotic", "recalcitrant", "sesquipedalian", "somnambulist", "triskaidekaphobia",
    "vicissitude", "xylotomous", "yokelish", "zephyr", "zeugma"};

    impossible = new String[] {"antidisestablishmentarianism", "floccinaucinihilipilification", "supercalifragilisticexpialidocious",
    "pneumonoultramicroscopicsilicovolcanoconiosis", "hippopotomonstrosesquipedaliophobia",
    "honorificabilitudinitatibus", "thyroparathyroidectomized", "psychoneuroendocrinological",
    "pseudopseudohypoparathyroidism", "spectrophotofluorometrically",
    "otorhinolaryngological", "hepaticocholangiocholecystenterostomies",
    "electroencephalographically", "radioimmunoelectrophoresis", "psychophysicotherapeutics",
    "antitransubstantiationalist", "floccinaucinihilipilificatious", "ultracrepidarian",
    "sesquicentennial", "xenotransplantation", "counterrevolutionaries", "incomprehensibilities",
    "uncharacteristically", "disproportionableness", "hyperaggressiveness", "misinterpretation",
    "counterintelligence", "disestablishmentarian", "incompatibilities", "microarchitectures",
    "uncontrollability", "electrocardiographic", "hypercholesterolemia", "immunoelectrophoresis",
    "magnetohydrodynamics", "neuropharmacological", "psychopharmacologist", "thermoelectrically",
    "ultramicroscopically", "unconstitutionality", "uncontrollably", "xylophonically",
    "zoogeographical", "bioluminescence", "cryptozoological", "dermatoglyphics",
    "flibbertigibbeting", "hippopotomonstrosesquipedalian"};
}

public String getRandomWord(String difficulty) {
  return ""; //placeholder
}

public int getWordCount(String difficulty) {
  return 0; // placeholder
}




