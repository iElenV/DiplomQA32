package ru.QA32.controller;



import ru.QA32.model.VetCard;
import ru.QA32.service.OwnerService;
import ru.QA32.service.VeterinarianService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CliController {
    public static void main(String[] args) {
        OwnerService ownerService = new OwnerService();
        VeterinarianService veterinarianService = new VeterinarianService();

        VetCard vetCard;

        while (true) {
            try {
                System.out.print("Выберите Вашу роль в системе: \n" +
                        "1 - Хозяин питомца \n" +
                        "2 - Ветеринар\n" +
                        "3 - Выход \n");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Выбираю: ");
                int nextInput1 = scanner.nextInt();

                // Выбор действий для хозяина питомца

                if (nextInput1 == 1) {
                    System.out.print("Введите Вашу фамилию: ");
                    String inputLastName = scanner.next();
                    if (ownerService.readOwner(inputLastName)==null) {
                        System.out.println("\u001b[32mВам необходимо зарегистрироваться в системе!\u001b[0m");
                        System.out.println("Пройти регистрацию (Да/Нет(выход))?");
                            String ans = scanner.next();
                            if (ans.equals("Да")) {
                                System.out.print("Введите имя: ");
                                String inputFirstname = scanner.next();
                                System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
                                String inputBirthDay = scanner.next();
                                System.out.print("Введите номер телефона: ");
                                String inputPhoneNumber = scanner.next();
                                System.out.println("\u001b[32mЗарегистрирован\u001b[0m " + ownerService.createOwner(inputFirstname,
                                        inputLastName,
                                        inputBirthDay,
                                        inputPhoneNumber));
                            }
                            if (ans.equals("Нет")) {
                                break;
                            }
                            if (!ans.equals("Да") && !ans.equals("Нет")) {
                                System.out.println("Неверный ввод! Работа программы завершена");
                                break;
                            }
                    } else System.out.println(ownerService.readOwner(inputLastName));

                        while (true) {
                            System.out.print("Выберите действие: \n" +
                                    "1 - Завести питомца\n" +
                                    "2 - Отдать питомца\n" +
                                    "3 - Покормить питомца\n" +
                                    "4 - Посмотреть всех моих питомцев\n" +
                                    "5 - Сколько лет питомцу\n" +
                                    "6 - Вернуться назад\n");

                            System.out.print("Выбираю: ");
                            int nextInput11 = scanner.nextInt();

                                if (nextInput11 == 1) {
                                System.out.print("Введите вид животного: кошачьи или собаки: ");
                                String inputspecies = scanner.next();
                                System.out.print("Введите породу: ");
                                String inputBreed = scanner.next();
                                System.out.print("Введите кличку: ");
                                String inputPetName = scanner.next();
                                System.out.print("Введите пол: ");
                                String inputSex = scanner.next();
                                System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД:");
                                String inputDateOfBirth = scanner.next();
                                System.out.print("Введите вес: ");
                                Double inputWeight = scanner.nextDouble();
                                System.out.println(ownerService.addPet(inputLastName, inputspecies,  inputBreed, inputPetName,
                                        inputSex, inputDateOfBirth, inputWeight));
                            }

                            if (nextInput11 == 2) {
                                System.out.print("Введите id: ");
                                int inputidPet = scanner.nextInt();
                                ownerService.deletePet(inputLastName, inputidPet);
                                // Ниже в комментрии вывод хозяина питомца для проверки
                                // System.out.println(ownerService.readOwner(inputLastName));
                            }

                            if (nextInput11 == 3) {
                                System.out.print("Введите id: ");
                                int inputidPet = scanner.nextInt();
                                System.out.print("Введите название корма: ");
                                String inputidPetFood = scanner.next();
                                System.out.println(ownerService.feedPet(inputLastName, inputidPet, inputidPetFood));
                            }

                            if (nextInput11 == 4) {
                                System.out.println(ownerService.viewPets(inputLastName));
                            }

                            if (nextInput11 == 5) {
                                System.out.print("Введите id: ");
                                int inputidPet = scanner.nextInt();
                                System.out.println(ownerService.calculateAgePet(inputLastName, inputidPet));
                            }

                            if (nextInput11 == 6) {
                                break;
                            }
                        }
                }




                // Выбор действий для ветеринара
                if (nextInput1 == 2)
                {
                    System.out.print("Введите Вашу фамилию: ");
                    String inputLastName = scanner.next();
                    System.out.print("Введите должность: ");
                    String inputPosition = scanner.next();
                    if (veterinarianService.readVeterinarian(inputLastName)==null) {
                        System.out.println("\u001b[32mВам необходимо зарегистрироваться в системе!\u001b[0m");
                        System.out.println("Пройти регистрацию (Да/Нет(выход))?");
                        String ans = scanner.next();
                        if (ans.equals("Да")) {
                            System.out.print("Введите имя: ");
                            String inputFirstname = scanner.next();
                            System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
                            String inputBirthDay = scanner.next();
                            System.out.print("Введите номер телефона: ");
                            String inputPhoneNumber = scanner.next();
                            System.out.println("\u001b[32mЗарегистрирован\u001b[0m " + veterinarianService.createVeterinarian(inputFirstname,
                                    inputLastName,
                                    inputBirthDay,
                                    inputPhoneNumber, inputPosition));
                        }
                        if (ans.equals("Нет")) {
                            break;
                        }
                        if (!ans.equals("Да") && !ans.equals("Нет")) {
                            System.out.println("Неверный ввод! Работа программы завершена");
                            break;
                        }
                    } else System.out.println(veterinarianService.readVeterinarian(inputLastName));

                    while (true) {
                        System.out.print("Выберите действие: \n" +
                                "1 - Проверить наличие карточки и создать, если нет\n" +
                                "2 - Осмотр питомца\n" +
                                "3 - Вакцинация\n" +
                                "4 - Вернуться назад\n");

                        int nextInput21 = scanner.nextInt();
                        if (nextInput21 == 1) {
                            System.out.print("Введите номер карточки животного для просмотра ее наличия: ");
                            int inputCardNumber = scanner.nextInt();

                           if (veterinarianService.readVetCard(inputCardNumber)==null) {
                               System.out.println("\u001b[32mОтветьте на пару вопросов чтобы заполнить карточку\u001b[0m");
                               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                               String  inputDate = LocalDateTime.now().format(formatter);
                               System.out.print("Кто у вас? кошечка, собачка?: ");
                               String inputSpecies = scanner.next();
                               System.out.print("Как зовут питомца: ");
                               String inputAnimalName = scanner.next();
                               System.out.print("Ваша фамилия: ");

                               String inputOwnerLastName = scanner.next();
                               String inputOwnerFirstName = ownerService.readOwner(inputOwnerLastName).getFirstName();
                               String inputType = " ";
                               String inputResult = " ";
                               System.out.println(veterinarianService.createVetCard(inputCardNumber,
                                       inputDate,
                                       inputSpecies,
                                       inputAnimalName,
                                       inputOwnerFirstName,
                                       inputOwnerLastName,
                                       inputPosition,
                                       inputLastName,
                                       inputType,
                                       inputResult));
                           } else System.out.println(veterinarianService.readVetCard(inputCardNumber));

                        }

                        if (nextInput21 == 2) {
                            System.out.print("Введите номер карточки животного: ");
                            int inputCardNumber = scanner.nextInt();
                            System.out.print("Введите результаты приема питомца: ");
                            String inputResult = scanner.next();
                            vetCard = veterinarianService.priem(inputCardNumber,inputResult);
                            System.out.println(vetCard);
                        }
                        if (nextInput21 == 3) {
                            System.out.print("Введите номер карточки животного: ");
                            int inputCardNumber = scanner.nextInt();
                            System.out.print("Вакцина: ");
                            String inputVac = scanner.next();
                            System.out.println(veterinarianService.priemVac(inputCardNumber, inputVac));

                        }

                        if (nextInput21 == 4) {

                            break;
                        }

                    }

                }

                if (nextInput1 == 3) {
                    break;
                }


            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}