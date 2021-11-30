package com.overbyte.gryphon.generator

import com.overbyte.gryphon.entity.Person
import com.overbyte.gryphon.enumerations.Gender
import java.io.File
import kotlin.random.Random


object PersonGenerator {
    val random = Random(System.currentTimeMillis())

    fun next(): Person {
        val mf = nextGender
        val first = if(mf == Gender.Male) nextFirstNameMale else nextFirstNameFemale
        val genderedAvatar = if(mf == Gender.Male) nextMaleAvatar else nextFemaleAvatar
        val last = nextLastName
        return Person().apply {
            firstName = first
            lastName = last
            phone = nextPhone
            email = "${first}_${last}@gmail.com".lowercase()
            address = AddressGenerator.next()
            gender = mf
            avatar = genderedAvatar
        }
    }

    private val nextPhone: String
        get() = "${random.nextLong(1111111111L, 9999999999L)}"

    private val nextFirstNameFemale
        get() = firstNamesFemale[random.nextInt(firstNamesFemale.count())]

    private val nextFirstNameMale
        get() = firstNamesMale[random.nextInt(firstNamesMale.count())]

    private val nextLastName
        get() = surnames[random.nextInt(surnames.count())].lowercase().capitalize()

    private val nextGender: Gender
        get() {
            val genders = Gender.values()
            return genders[random.nextInt(genders.size)]
        }

    private val firstNamesFemale = listOf(
        "Mary",
        "Jennifer",
        "Patricia",
        "Linda",
        "Elizabeth",
        "Barbara",
        "Jessica",
        "Susan",
        "Lisa",
        "Sarah",
        "Karen",
        "Ashley",
        "Justin",
        "Michelle",
        "Kimberly",
        "Nancy",
        "Sandra",
        "Amanda",
        "Stephanie",
        "Emily",
        "Melissa",
        "Donna",
        "Rebecca",
        "Deborah",
        "Laura",
        "Cynthia",
        "Carol",
        "Amy",
        "Margaret",
        "Sharon",
        "Angela",
        "Maria",
        "Nicole",
        "Kathleen",
        "Samantha",
        "Betty",
        "Brenda",
        "Pamela",
        "Kelly",
        "Heather",
        "Rachel",
        "Christine",
        "Debra",
        "Katherine",
        "Christina",
        "Julie",
        "Anna",
    )

    private val firstNamesMale = listOf(
        "Michael",
        "James",
        "John",
        "Robert",
        "David",
        "William",
        "Christopher",
        "Joseph",
        "Richard",
        "Daniel",
        "Thomas",
        "Matthew",
        "Charles",
        "Anthony",
        "Mark",
        "Joshua",
        "Steven",
        "Andrew",
        "Kevin",
        "Brian",
        "Jason",
        "Timothy",
        "Paul",
        "Kenneth",
        "Ryan",
        "Jeffrey",
        "Donald",
        "Eric",
        "Jacob",
        "Nicholas",
        "Jonathan",
        "Ronald",
        "Brandon",
        "Gary",
        "Edward",
        "Stephen",
        "Scott",
        "George",
        "Jose",
        "Gregory",
        "Larry",
        "Alexander",
        "Benjamin",
        "Patrick",
        "Tyler",
        "Samuel",
        "Aaron",
        "Adam",
        "Zachary",
        "Dennis",
        "Nathan",
        "Jordan",
        "Kyle",
    )

    private val nextMaleAvatar: ByteArray
        get() = maleAvatars[random.nextInt(maleAvatars.count())]

    private val nextFemaleAvatar: ByteArray
        get() = femaleAvatars[random.nextInt(femaleAvatars.count())]


    private val surnames = listOf(
        "SMITH",
        "JOHNSON",
        "WILLIAMS",
        "BROWN",
        "JONES",
        "GARCIA",
        "RODRIGUEZ",
        "MILLER",
        "MARTINEZ",
        "DAVIS",
        "HERNANDEZ",
        "LOPEZ",
        "GONZALEZ",
        "WILSON",
        "ANDERSON",
        "THOMAS",
        "TAYLOR",
        "LEE",
        "MOORE",
        "JACKSON",
        "PEREZ",
        "MARTIN",
        "THOMPSON",
        "WHITE",
        "SANCHEZ",
        "HARRIS",
        "RAMIREZ",
        "CLARK",
        "LEWIS",
        "ROBINSON",
        "WALKER",
        "YOUNG",
        "HALL",
        "ALLEN",
        "TORRES",
        "NGUYEN",
        "WRIGHT",
        "FLORES",
        "KING",
        "SCOTT",
        "RIVERA",
        "GREEN",
        "HILL",
        "ADAMS",
        "BAKER",
        "NELSON",
        "MITCHELL",
        "CAMPBELL",
        "GOMEZ",
        "CARTER",
        "ROBERTS",
        "DIAZ",
        "PHILLIPS",
        "EVANS",
        "TURNER",
        "REYES",
        "CRUZ",
        "PARKER",
        "EDWARDS",
        "COLLINS",
        "STEWART",
        "MORRIS",
        "MORALES",
        "ORTIZ",
        "GUTIERREZ",
        "MURPHY",
        "ROGERS",
        "COOK",
        "KIM",
        "MORGAN",
        "COOPER",
        "RAMOS",
        "PETERSON",
        "GONZALES",
        "BELL",
        "REED",
        "BAILEY",
        "CHAVEZ",
        "KELLY",
        "HOWARD",
        "RICHARDSON",
        "WARD",
        "COX",
        "RUIZ",
        "BROOKS",
        "WATSON",
        "WOOD",
        "JAMES",
        "MENDOZA",
        "GRAY",
        "BENNETT",
        "ALVAREZ",
        "CASTILLO",
        "PRICE",
        "HUGHES",
        "VASQUEZ",
        "SANDERS",
        "JIMENEZ",
        "LONG",
        "FOSTER",
    )

    private fun getAvatars(prefix: String): List<ByteArray> {
        val path = File("images/avatar/$prefix/")
        val allFiles = path.listFiles()
        return allFiles.map { file ->
            file.readBytes()
        }
    }

    private val maleAvatars = getAvatars("male")

    private val femaleAvatars = getAvatars("female")
}