package io.github.kashifo.modern.android.models

data class GBook (
    val id:String, val volumeInfo:VolumeInfo
        )

data class VolumeInfo (
    val title:String,
    val authors:List<String>,
    val publisher:String,
    val imageLinks:ImageLinks,
    val pageCount:String,
//    val industryIdentifiers:String,
    val printType:String,
    val language:String,
//    val previewLink:String,
//    val infoLink:String
)



data class ImageLinks(
    val smallThumbnail:String,
    val thumbnail:String,
)

/*
{
items[
id,
volumeInfo{

title,
authors,
publisher,
ImageLinks imageLinks,
pageCount
Object industryIdentifiers;
printType;
language;
previewLink;
infoLink;
}

class ImageLinks
  smallThumbnail
  thumbnail
 */