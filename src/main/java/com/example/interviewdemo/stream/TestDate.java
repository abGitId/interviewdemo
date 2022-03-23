package com.example.interviewdemo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class TestDate {
  public static void main(String[] args) {
    //
    List<Voucher> vouchers = getScheduledVouchers();
    vouchers.forEach(System.out::println);

    Comparator<Voucher> voucherComparatorByStartDateStr =
        Comparator.comparing(Voucher::getStartDate);
    Comparator<Voucher> voucherComparatorByStartDate =
        Comparator.comparing(voucher -> ZonedDateTime.parse(voucher.getStartDate()));

    Collections.sort(vouchers, voucherComparatorByStartDate);
    System.out.println("after sorting------------------>>\n");
    vouchers.forEach(System.out::println);
    int size = vouchers.size();
    System.out.println("size = " + size);
    for (int i = 0; i < size; i++) {
      System.out.println("i = " + i);
      if (i == size - 1) {
        System.out.println("last loop");
      } else {
        if(Objects.isNull(vouchers.get(i).getEndDate()) || Objects.isNull(vouchers.get(i).getStartDate())){
          System.out.println(
                  "Scheduled date is not valid... difference between dates end date="
                          + vouchers.get(i).getEndDate()
                          + " and next scheduled start date="
                          + vouchers.get(i + 1).getStartDate()
                          + " is not valid");
          return;
        }
        System.out.println("i = " + ZonedDateTime.parse(vouchers.get(i).getEndDate()));
        long minutes =
            Duration.between(
                    ZonedDateTime.parse(vouchers.get(i).getEndDate()),
                    ZonedDateTime.parse(vouchers.get(i + 1).getStartDate()))
                .toMinutes();
        System.out.println("minutes = " + minutes);
        if (minutes != 1l) {
          System.out.println(
              "Scheduled date is not valid... difference between dates end date="
                  + vouchers.get(i).getEndDate()
                  + " and next scheduled start date="
                  + vouchers.get(i + 1).getStartDate()
                  + " is not valid");
        }
      }
    }

    /*List<String> dateList = new ArrayList<>();
    vouchers.forEach(
        voucher -> {
          dateList.add(voucher.getStartDate());
          dateList.add(voucher.getEndDate());
        });
    dateList.forEach(System.out::println);

    AtomicReference<String> refDate = new AtomicReference<>(null);
    dateList.forEach(
        date -> {
          if (refDate.get() == null) {
            refDate.set(date);
          } else {
            long minutes =
                Duration.between(ZonedDateTime.parse(refDate.get()), ZonedDateTime.parse(date))
                    .toMinutes();
            long seconds =
                Duration.between(ZonedDateTime.parse(refDate.get()), ZonedDateTime.parse(date))
                    .getSeconds();

            System.out.println("minutes = " + minutes);
            // -- System.out.println("seconds = " + seconds);
            refDate.set(date);
          }
        });*/
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class Voucher {
    private String code;
    private String startDate;
    private String endDate;
  }

  public static List<Voucher> getScheduledVouchers() {
    return Arrays.asList(
        new Voucher("abc", "2021-02-16T13:00:00Z", "2021-02-20T13:00:00Z"),
        new Voucher("lmn", "2021-02-25T13:01:00Z", "2021-02-28T13:00:00Z"),
        new Voucher("lmn", "2021-02-28T13:01:00Z", "2021-03-28T13:00:00Z"),
        new Voucher("xyz", "2021-02-20T13:01:00Z", null));
  }
}
