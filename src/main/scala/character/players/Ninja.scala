package character.players
import exceptions.WeaponException
import weapon.Weapon

/** Represents a Ninja.
  *
  * A Ninja is a playable character
  *
  * @param name
  *   The name of the character
  * @param maxLife
  *   The max amount of life points 
  * @param life
  *   The life of the character
  * @param defense
  *   The defense of the character
  * @param weight
  *   The weight of the character
  *
  * @constructor Creates a new Ninja character with the specified properties.
  *
  * @author
  *   asouris
  */
class Ninja(
    name: String,
    maxLife: Int,
    life: Int,
    defense: Int,
    weight: Int
) extends AbstractPlayer(name, maxLife, life, defense, weight){
  

  /**
   * Checks whether this ninja is equal to another object.
   *
   * @param other The object to compare with.
   * @return True if the objects are equal, false otherwise.
   */
  override def equals(other: Any): Boolean = {
    other match
      case ninja1: Ninja =>
        name == ninja1.getName && maxLife == ninja1.getMaxLife && life == ninja1.getLife && defense == ninja1.getDefense && weight == ninja1.getWeight
      case _ =>
        false
  }

  /**
   * Returns a string representation of this ninja.
   *
   * @return A string representation containing the ninja's properties.
   */
  override def toString: String = {
    s"Ninja($name, $maxLife, $getLife, $defense, $weight)"
  }

  /**
   * Equips a new weapon to the ninja via the method validEquip.
   * This method overrides the one declared in Player.
   *
   * @param newWeapon The weapon to be equipped.
   */
  override def equip(newWeapon: Weapon): Unit = {
    if(newWeapon.isEquippableByNinja) {
      super.validEquip(newWeapon.toWeapon)
    }
    else{
      throw WeaponException(s"$this cannot equip $newWeapon")
    }
  }

}