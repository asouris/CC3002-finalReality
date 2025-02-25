package weapon

import character.players.Player
import exceptions.{BadBehaviourException, NoneException}

/**
 * An abstract base class representing a weapon.
 *
 * @param name   The name of the weapon.
 * @param attack The attack value of the weapon.
 * @param weight The weight of the weapon.
 *
 * @author asouris
 */
abstract class AbstractWeapon(private val name: String, private val attack : Int, private val weight: Int) extends Weapon {
  require(name != "")
  require(attack >= 1)
  require(weight >= 1)

  /** Holds a possible owner of the weapon, which is a player */
  private var owner: Option[Player] = None

  /**
   * Retrieves the name of the weapon.
   *
   * @return The name of the weapon.
   */
  def getName: String = name

  /**
   * Retrieves the attack value of the weapon.
   *
   * @return The attack value of the weapon.
   */
  def getAttack: Int = attack

  /**
   * Retrieves the weight of the weapon.
   *
   * @return The weight of the weapon.
   */
  def getWeight: Int = weight

  /**
   * Retrieves the owner of the weapon, if any.
   *
   * @return An option containing the owner of the weapon, or None if the weapon has no owner.
   */
  def getOwner: Player = {
    owner match
      case Some(value) => value
      case None => throw NoneException("There is no owner")
  }

  /**
   * Checks if the weapon has an owner.
   *
   * @return True if the weapon has an owner, false otherwise.
   */
  def hasOwner: Boolean = owner.isDefined

  /**
   * Sets the owner of the weapon.
   *
   * @param player The player to set as the owner of the weapon.
   * @throws BadBehaviourException If the weapon already has an owner.
   */
  def setOwner(player: Player): Unit = {
    if (this.hasOwner) {
      throw BadBehaviourException(s"Weapon $name already has an owner, weapon cannot have 2 owners")
    }
    else {
      owner = Some(player)
    }
  }

  /**
   * Sets owner to None
   */
  override def removeOwner(): Unit = {
    owner = None
  }

  /**
   * returns true if is equippable by a ninja
   *
   * @return
   */
  def isEquippableByNinja: Boolean = false

  /**
   * returns true if is equippable by a paladin
   *
   * @return
   */
  def isEquippableByPaladin: Boolean = false

  /**
   * returns true if is equippable by a warrior
   *
   * @return
   */
  def isEquippableByWarrior: Boolean = false

  /**
   * returns true if is equippable by a whiteMage
   *
   * @return
   */
  def isEquippableByWhiteMage: Boolean = false

  /**
   * returns true if is equippable by a blackMage
   *
   * @return
   */
  def isEquippableByBlackMage: Boolean = false
  
}
  
