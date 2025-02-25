package weapon

/** Represents a Sword, a type of weapon.
 *
 * A Sword is a weapon with a name, attack power, weight.
 *
 * @constructor Creates a new Sword with the specified properties.
 * @param name   The name of the Sword.
 * @param attack The attack power of the Sword.
 * @param weight The weight of the Sword.
 *
 * @author asouris
 */

class Sword(name: String, attack: Int, weight: Int)
  extends AbstractWeapon(name, attack, weight){

  /**
   * Checks if this Sword is equal to another object.
   *
   * Two Swords are considered equal if they have the same name, attack power, and weight.
   *
   * @param other The object to compare with.
   * @return `true` if the objects are equal, `false` otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case sword1: Sword =>
        name == sword1.getName && attack == sword1.getAttack && weight == sword1.getWeight
      case _ =>
        false
  }

  /**
   * Returns a string representation of this Sword.
   *
   * @return A string representation containing the Sword's properties.
   */
  override def toString: String = {
    s"Sword($name, $attack, $weight)"
  }

  /**
   * returns true if is equippable by a paladin
   *
   * @return
   */
  override def isEquippableByPaladin: Boolean = true

  /**
   * returns true if is equippable by a ninja
   *
   * @return
   */
  override def isEquippableByNinja: Boolean = true

  /**
   * returns true if is equippable by a warrior
   *
   * @return
   */
  override def isEquippableByWarrior: Boolean = true

  /**
   * returns true if is equippable by a blackMage
   *
   * @return
   */
  override def isEquippableByBlackMage: Boolean = true


}
