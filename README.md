# Codename One JSON Library
###### A library to read and write JSON in Codename One

## Synopsis

This library is a port of [this J2ME JSON library](https://github.com/greyson/j2me-json) so that it can be used in Codename One.  Only minor changes have been made in order to improve performance.  

Codename One already includes a JSON parser, so why package up another library?  One reason is for pure variety.  The interface of this library is different than the built-in CN1 parser and this might be preferrable to some.  Another reason is that it is easy to use this library outside of Codename One.  If I'm writing code that I want to reuse in CN1 and other Java environments, I might choose to use this library for portability.

## License

Apache License 2.0

## Requirements

1. Codename One 1.0 or higher

## Installation 

1. Download the [CN1JSON.cn1lib](https://github.com/shannah/CN1JSON/blob/master/dist/CN1JSON.cn1lib?raw=true) file and copy it into your Codename One Application's "lib" directory.
2. Right click on your application's icon in the Netbeans project explorer, and select "Refresh Libs"

## Usage Examples

```

        JSONObject index = new JSONObject(myJSONString);
        tour.setTourId(index.getInt("tour_id"));
        tour.setName(index.getString("tour_name"));
        
        JSONArray dests = index.getJSONArray("destinations");
        Map<String,SoundFile> audioFileIndex = new HashMap<String,SoundFile>();
        for ( int i=0; i<dests.length(); i++){
            JSONObject dest = dests.getJSONObject(i);
            PointOfInterest poi = new PointOfInterest();
            poi.setId(dest.getInt("tour_destination_id"));
            poi.setName(dest.getString("destination_name"));
            poi.setDescription(dest.getString("destination_description"));
            
            SoundFile sf = new SoundFile();
            sf.setStorageKey("poi:"+poi.getId());
            sf.setMimetype(dest.getString("audio_file_mimetype"));
            poi.setSoundFile(sf);
            audioFileIndex.put(dest.getString("audio_file"), sf);
            tour.addPointOfInterest(poi);
            
        }
```

You can find other usage examples on [the J2ME-JSON site](https://github.com/greyson/j2me-json).

 ### Credits
 
 1. Library ported packaged by [Steve Hannah](https://twitter.com/shannah78)
 2. Original JTar Library by [Greyson](https://github.com/greyson)
