import kotlin.random.Random//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun calculDefenseTotal(sdd:Int,typearmure:Int,qra:Int){
    val deftotal = sdd + typearmure + qra
    println(deftotal)

}

fun lanceDes(nb_des :Int,nb_face :Int): Int{
    var resultatTotal = 0

    // Pour chaque dé, générer un nombre aléatoire entre 1 et nombreDeFaces
    for (i in 1..nb_des) {
        val resultatDes = Random.nextInt(1, nb_des + 1)
        resultatTotal += resultatDes
        println("Dé $i : $resultatDes")
    }

  return resultatTotal

}
fun calculDegatArme(nb_des: Int,nb_face: Int, bonusArme: Int,SeuilCrit:Int,multipliCrit:Int): Int {
    var degat = 0
    val lance = lanceDes(nb_des, nb_face)
    if (lance > SeuilCrit) {
        degat += lance * multipliCrit

    }
    degat += bonusArme
    return degat
}

/**
 * Fonction qui calcule les dégats suite à une attaque.
 * @param nomAttaquant Nom de l'attaquant
 * @param nomCible Nom du personnage attaqué
 * @param pv Nombre de points de vie du personnage attaqué.
 * @param degat Valeur des dégats bruts de l'arme.
 * @param defenseTotal Entier représentant la protection offerte par la défense.
 * @return Un chaîne de caractères présentant l'issue de l'attaque.
 */
fun attaque(nomAttaquant: String,nomCible: String, pv: Int, degat: Int,defenseTotal:Int ): String {
    var attack = degat-defenseTotal
    if  (attack<0){
        attack = 0
    }
    var vie = pv - attack
    return "$nomAttaquant attaque $nomCible pour $attack point de dégâts\n"


}

fun boirePotion(nom_perso:Int,pointsdevie:Int,pvMax:Int,RecupPV:Int): String{
    var exPV = pvMax
    var lp = pointsdevie
    var boire = RecupPV + pointsdevie
    if(boire > exPV){
        lp = pvMax
    }else{
        lp = boire
    }
    var total_recup = RecupPV
    if(pointsdevie + total_recup > pvMax){
        total_recup = pvMax - pointsdevie
    }
    return "$nom_perso avait $pointsdevie PV il a recupéré $total_recup PV il a maintenant $lp PV"
}

fun main(){
    calculDefenseTotal(7,8,14)
    lanceDes(2,6)
    println("Test de la fonction calculDegatArme pour :\n" +
            "   - sdd : 7\n" +
            "   - typearmure: 8\n" +
            "   - qra: 14\n" +
            "   -RESULTAT : ${calculDegatArme(2,6,2,6,2)}")

}





