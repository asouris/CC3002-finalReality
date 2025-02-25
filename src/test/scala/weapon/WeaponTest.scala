package weapon


import character.players.Warrior
import character.players.BlackMage
import exceptions.{BadBehaviourException, NoneException}



class WeaponTest extends munit.FunSuite{
  var sword: Sword = _
  var axe: Axe = _
  var wand: Wand = _
  var bow : Bow = _
  var staff : Staff = _

  var warrior : Warrior = _
  var mage : BlackMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    sword = new Sword("destroyer", 5, 10)
    axe = new Axe("supreme", 4, 15)
    wand = new Wand("ElProgcomp", 10, 10, 20)
    bow = new Bow("Bow", 15, 15)
    staff = new Staff("staff", 15, 20, 25)

    warrior = new Warrior("warrior", 20, 20, 10, 15)
    mage = new BlackMage("mage", 10, 10, 4, 15, 6, 6)

  }

  test("A weapon cannot be created with an empty name"){
    var axeGood = Axe("axeGood", 10, 10)
    intercept[IllegalArgumentException] {
      var axeBad = Axe("", 10, 10)
    }
    intercept[IllegalArgumentException] {
      var wandBad = Wand("", 10, 10, 5)
    }
  }

  test("A weapon cannot be created with attributes attack and weight lesser than 1"){
    var axe0 = Axe("axe0", 1, 1)
    var axe1 = Axe("axe1", 100, 10)

    intercept[IllegalArgumentException] {
      var axeBad = Axe("axeBad", 0, 10)
    }
    intercept[IllegalArgumentException] {
      var bowBad = Bow("bowBad", 100, -1)
    }
  }

  test("hasOwner should return true if the weapon has an owner, false if not"){
    assert(!wand.hasOwner)
    mage.equip(wand)
    assert(wand.hasOwner)
  }

  test("setOwner should set the owner of the weapon") {
    sword.setOwner(warrior)
    assert(sword.getOwner == warrior)
  }

  test("setOwner should throw an exception when trying to set an owner to a weapon with owner"){
    sword.setOwner(warrior)
    intercept[BadBehaviourException]{
      sword.setOwner(mage)
    }
  }

  test("Boolean testing"){
    assert(axe.isEquippableByPaladin && axe.isEquippableByWarrior)

    assert(bow.isEquippableByWarrior && bow.isEquippableByNinja && bow.isEquippableByWhiteMage)

    assert(staff.isEquippableByWhiteMage && staff.isEquippableByBlackMage)

    assert(sword.isEquippableByNinja && sword.isEquippableByWarrior && sword.isEquippableByBlackMage)

    assert(wand.isEquippableByWhiteMage && wand.isEquippableByBlackMage && wand.isEquippableByNinja)

  }

  test("getOwner with no owner"){
    intercept[NoneException]{
      sword.getOwner
    }
  }

}
