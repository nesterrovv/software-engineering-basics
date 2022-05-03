package java.collectionUsage;

import java.data.*;
import java.time.ZonedDateTime;
import java.util.*;

public class FieldReceiver {

    private final CollectionManager collectionManager;

    public FieldReceiver(CollectionManager collectionManager) {
        this.collectionManager = new CollectionManager();
    }

    /**
     * Method for receiving ID of element
     * @return int ID
     */
    public int receiveId() {
        int maxId = 0;
        HashSet<Person> persons = collectionManager.getPersons();
        for (Person person : persons) {
            if (person.getId() > maxId) {
                maxId = person.getId();
            }
        }
        return maxId + 1;
    }

    /**
     * Method for receiving name of element
     * @return String name
     */
    public String receiveName() {
        while (true) {
            try {
                System.out.println("Attention! If name will be so long, you may lose some part of this information");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a name: ");
                String name = scanner.nextLine().trim();
                if (name.equals("")) {
                    System.out.println("This value cannot be empty. Try again");
                    continue;
                }
                return name;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be string. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving x-coordinate of element
     * @return long x
     */
    public long receiveX() {
        while (true) {
            try {
                System.out.print("Enter X coordinate. Max value is 690. ");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Value cannot be empty. ");
                long x = scanner.nextLong();
                System.out.print("Value cannot be empty. ");
                String xx = Long.toString(x);
                if (x > 690) {
                    System.out.println("Max value is 690. Try again. ");
                    continue;
                }
                if (xx.equals("") ) {
                    System.out.println("This value cannot be empty. Try again. ");
                    continue;
                }
                return x;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving y-coordinate of element
     * @return Float y
     */
    public Float receiveY() {
        while (true) {
            try {
                System.out.print("Enter Y coordinate. This value cannot be empty. ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextFloat();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a float-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /** Method for making coordinates by using methods receiveX() and receiveY() */
    public Coordinates receiveCoordinates() {
        return new Coordinates(receiveX(), receiveY());
    }

    public String returnDate() {
        return ZonedDateTime.now().toString();
    }

    /**
     * Method for receiving height of element
     * @return long height
     */
    public long receiveHeight() {
        while (true) {
            try {
                System.out.print("Enter height. Value must be greater than 0. ");
                Scanner scanner = new Scanner(System.in);
                long height = scanner.nextLong();
                if (height <= 0) {
                    System.out.println("This value must be greater than 0. Try again. ");
                    continue;
                }
                return height;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving x-coordinate of location of element
     * @return long xLocation
     */
    public long receiveXLocation() {
        while (true) {
            try {
                System.out.print("Enter X coordinate of location. ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextLong();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving y-coordinate of element
     * @return Double yLocation
     */
    public Double receiveYLocation() {
        while (true) {
            try {
                System.out.print("Enter Y coordinate of location: ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextDouble();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving name of element`s location
     * @return String nameLocation
     */
    public String receiveNameLocation() {
        while (true) {
            try {
                System.out.println("Attention! If name will be so long, you may lose some part of this information");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a name of location: ");
                String nameLocation = scanner.nextLine().trim();
                if (nameLocation.equals("")) {
                    System.out.println("This value cannot be empty. Try again. ");
                }
                return nameLocation;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a string. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving Location field by using methods receiveXLocation(),
     * receiveYLocation() and receiveNameLocation()
     * @return Location location
     */
    public Location receiveLocation() {
        return new Location(receiveXLocation(), receiveYLocation(), receiveNameLocation());
    }

    /**
     * Method for receiving eye color of element
     * @return EyeColor eyeColor
     */
    public EyeColor receiveEyeColor() {
        while (true) {
            try {
                System.out.println("Choose variant of eye color.");
                System.out.print("Variants: 1 - GREEN, 2 - RED, 3 - BLUE. Enter the color: ");
                Scanner scanner = new Scanner(System.in);
                String eyeChoose = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
                switch (eyeChoose) {
                    case "GREEN":
                        return EyeColor.GREEN;
                    case "RED":
                        return EyeColor.RED;
                    case "BLUE":
                        return EyeColor.BLUE;
                    default:
                        break;
                }
                System.out.println("You should to enter 1, 2 or 3. Try again. ");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a number (1, 2 or 3). Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving hair color of element
     * @return HairColor hairColor
     */
    public HairColor receiveHairColor() {
        while (true) {
            try {
                System.out.println("Choose variant of hair color.");
                System.out.print("Variants: 1 - BLUE, 2 - YELLOW, 3 - ORANGE. Enter the color: ");
                Scanner scanner = new Scanner(System.in);
                String hairChoice = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
                switch (hairChoice) {
                    case "BLUE":
                        return HairColor.BLUE;
                    case "YELLOW":
                        return HairColor.YELLOW;
                    case "ORANGE":
                        return HairColor.ORANGE;
                    default:
                        break;
                }
                System.out.println("You should to enter 1, 2 or 3. Try again. ");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a number (1, 2 or 3). Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving nationality of element
     * @return Country nationality
     */
    public Country receiveNationality() {
        while (true) {
            try {
                System.out.println("Choose variant of nationality.");
                System.out.print("Variants: 1 - GERMANY, 2 - CHINA, 3 - NORTH KOREA. Enter name of country: ");
                Scanner scanner = new Scanner(System.in);
                String nationalityChoice = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
                switch (nationalityChoice) {
                    case "GERMANY":
                        return Country.GERMANY;
                    case "CHINA":
                        return Country.CHINA;
                    case "NORTH KOREA":
                        return Country.NORTH_KOREA;
                    default:
                        break;
                }
                System.out.println("You should to enter a value from list.. Try again. ");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be string. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }
}
