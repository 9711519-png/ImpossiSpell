import java.util.Random;

public class Wordbank {

  // word lists by difficulty
  private String[] easy;
  private String[] medium;
  private String[] hard;
  private String[] difficult;
  private String[] expert;
  private String[] insane;
  private String[] impossible;

  private Random rand = new Random(); // random generator

  public Wordbank() {

    // each array stores words for a difficulty level

    easy = new String[] {
"cat","dog","sun","hat","tree","book","milk","car","fish","star",
"ball","cup","pen","bed","door","frog","apple","bird","cake","water",
"house","mouse","shoe","clock","rain","snow","leaf","grass","toy","train",
"boat","plane","phone","lamp","chair","table","sock","shirt","cloud","river",
"stone","wind","fire","sand","road","smile","jump","run","play","sleep"};
    

  medium = new String[] {
"garden","puzzle","whisper","silver","rocket","planet","jungle","castle","mirror","window",
"thunder","danger","brighten","silent","purple","bottle","planetary","button","closet","frozen",
"bridge","forest","mountain","valley","desert","island","ocean","camera","laptop","picture",
"animal","bicycle","candle","diamond","engine","flower","glacier","hammer","insect","jacket",
"kitchen","library","machine","notebook","orange","pencil","quartz","rabbit","street","tunnel"};
    
  hard = new String[] {
"silhouette","pharaoh","chaos","rhythm","gravity","nebula","oxygen","volcano","algorithm","microscope",
"catastrophe","dominion","eclipse","fracture","galaxy","horizon","illusion","justice","kinetic","luminous",
"magnetic","narrative","opponent","paradox","quadrant","reptilian","symphony","technology","umbrella","velocity",
"whimsical","xenon","yesterday","zoology","archive","boundary","collapse","dimension","entropy","formation",
"geometry","hypothesis","infinity","junction","knowledge","latitude","molecule","notation","orbit","protocol"};
    
  difficult = new String[] {
"onomatopoeia","bureaucracy","architecture","metamorphosis","consciousness","characterization","indistinguishable",
"revolutionary","circumference","decomposition","implementation","interpretation","juxtaposition","miscommunication",
"nondisclosure","overgeneralization","personalization","quantification","reconfiguration","standardization",
"transcontinental","underestimation","visualization","authentication","bioluminescence","counterproductive",
"disproportionate","electromagnetism","fundamentalism","hyperventilation","internationalism","justification",
"legitimization","multidimensional","nonconventional","overcompensation","postmodernism","recontextualization",
"systematization","uncharacteristic","virtualization","waterproofing","xylophonist","yellowishness","zealousness",
"reconstruction","deinstitutionalization","unpredictability","interdisciplinary","overintellectualization"};
    
  expert = new String[] {
"juxtaposition","magnanimous","idiosyncratic","equilibrium","anachronistic","benevolence","circumlocution",
"disenfranchisement","epistemology","fallacious","grandiloquent","heterogeneous","iconoclasm","juxtaposed",
"kaleidoscopic","lexicographer","metaphysical","nonconformist","obfuscation","pernicious","quintessential",
"recalcitrant","sesquipedalian","transcendental","ubiquitous","vicarious","witticism","xenophobia","youthfulness",
"zephyrlike","amelioration","belligerence","cognizance","deleterious","effervescence","fortuitous","gregarious",
"hierarchical","incongruous","juxtapositioned","karyotype","lucidification","magniloquence","nefarious",
"obstreperous","perspicacious","quiescent","reminiscence","supercilious","temerity"};
    
  insane = new String[] {
"synecdoche","schadenfreude","quintessential","antagonistic","antidisestablishmentarianism","pneumonoultramicroscopicsilicovolcanoconiosis",
"honorificabilitudinitatibus","floccinaucinihilipilification","hippopotomonstrosesquipedaliophobia","supercalifragilisticexpialidocious",
"thyroparathyroidectomized","dichlorodifluoromethane","otorhinolaryngological","pseudopseudohypoparathyroidism","electroencephalographically",
"immunoelectrophoretically","hexakosioihexekontahexaphobia","otorhinolaryngologist","psychoneuroimmunology","biophotonic",
"cryptozoological","thermodynamically","electrodynamometer","microelectromechanical","neurophysiological","immunohistochemistry",
"photoelectrochemical","thermogravimetric","electrocardiography","radioimmunoassay","spectrophotometric","chromatographically",
"paleoclimatology","astrobiological","geomagnetically","hydrodynamically","electromechanical","nanotechnology","bioinformatics",
"cryopreservation","electrophysiology","pseudoscientific","interplanetary","ultramicroscopic","extraterrestrial","nonferromagnetic",
"photosynthetic","chemoreception","electroreception","thermoregulation","bioluminescence"};
    
impossible = new String[] {
"antidisestablishmentarianism", "pneumonoultramicroscopicsilicovolcanoconiosis", "hippopotomonstrosesquipedaliophobia", "floccinaucinihilipilification", "honorificabilitudinitatibus", "thyroparathyroidectomized", "dichlorodifluoromethane", "otorhinolaryngological", "pseudopseudohypoparathyroidism", "electroencephalographically",
"immunoelectrophoretically", "hexakosioihexekontahexaphobia", "otorhinolaryngologist", "psychoneuroimmunology", "biophotonic", "cryptozoological", "thermodynamically", "electrodynamometer", "microelectromechanical", "neurophysiological",
"immunohistochemistry", "photoelectrochemical", "thermogravimetric", "electrocardiography", "radioimmunoassay", "spectrophotometric", "chromatographically", "paleoclimatology", "astrobiological", "geomagnetically",
"hydrodynamically", "electromechanical", "nanotechnology", "bioinformatics", "cryopreservation", "electrophysiology", "pseudoscientific", "interplanetary", "ultramicroscopic", "extraterrestrial",
"nonferromagnetic", "photosynthetic", "chemoreception", "electroreception", "thermoregulation", "bioluminescence", "xenotransplantation", "immunomodulatory", "neuroplasticity", "electroretinography"};

  }

  public String getRandomWord(String difficulty) {
    // get correct list based on difficulty
    String[] list = getList(difficulty);

    if (list == null || list.length == 0) {
      return "No words found"; // safety check
    }

    int index = rand.nextInt(list.length); // random index
    return list[index]; // return random word
  }

  private String[] getList(String difficulty) {
    // match difficulty string to correct array
    switch (difficulty.toLowerCase()) {
      case "easy": return easy;
      case "medium": return medium;
      case "hard": return hard;
      case "difficult": return difficult;
      case "expert": return expert;
      case "insane": return insane;
      case "impossible": return impossible;
      default: return null;
    }
  }
}
