package com.makeathon.outliers.screencontentproviderservice.converter;

import com.makeathon.outliers.screencontentproviderservice.dto.ContentEntries;
import com.makeathon.outliers.screencontentproviderservice.model.BookingEntries;
import org.springframework.core.convert.converter.Converter;

public class BookingEntriesToContentEntriesConverter implements Converter<BookingEntries, ContentEntries> {

  @Override
  public ContentEntries convert(BookingEntries bookingEntries) {
    return null;
  }
}
