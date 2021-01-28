# A ReSTful service for MetaMapLite

A ReSTful service for MetaMapLite which includes support for Web
Browsers.  This is an JAX-RS service implementated using Jersey
(https://eclipse-ee4j.github.io/jersey/).

## Configuring the Service

In the directory: 'src/main/webapp/config/metamaplite.properties' the
property: 'metamaplite.index.directory' to points to the dataset
indexes to used by MetaMapLite.  If the indexes are in
'src/main/webapp' then the path must be relative to 'src/main/webapp'.
If the indexes reside outside of your application server then the path
must be an absolute path.  This is also the case for the OpenNLP
models used for part-of-speech tagging and phrase chunking (the
properties: 'opennlp.en-pos.bin.path' and
'opennlp.en-chunker.bin.path'.)

## Compiling

Requires Maven to compile:

    mvn package

The command above will generate a war file suitable for loading into a
servlet engine such as Apache Tomcat or Jetty.

## Development Directory Organization

Below is a pictorial representation of a possible directory
organization for a servlet containing MetaMapLite.  The
main properties file 'metamaplite.properties' resides in the 'config'
directory.  The inverted file indexes used by MetaMapLite reside in
the 'ivf' directory.  The opennlp models reside in data/models
directory.

     sample-webapp/
         |
         +- config
         +- data
         |   |
         |   +- ivf
         |   |   |
         |   |   +- strict 
         |   |         |
         |   |         +- indices
         |   |         |   |
         |   |         |   +- cuiconcept
         |   |         |   +- cuisourceinfo
         |   |         |   +- cuist
         |   |         |
         |   |         +- tables
         |   +- models
         |
         +- lib
         +- src
         |   |
         |   +- main
         |       |
         |       +- java
         |       |   |
         |       |   +- sample
         |       |   
         |       +- webapp
         |           |
         |           +- WEB-INF
         |               |
         |               +- WebContent
         |               +- classes
         |                   |
         |                   +- sample
         |                   
         +- target
             |
             +- web
                 |
                 +- sample
    
An attempt has been made to make the directory structure somewhat
comformant to Maven's recommended directory organization to allow
relatively painless migration to Maven if desired.

Note: the indexes for the inverted files can be outside of the
container if the servlet engine supports it.  Some modifications to
MetaMapLiteFactory may be needed to support it.  This support will
probably be added in a future release.

## Specifying the MetaMapLite Version

The Maven project file (pom.xml) must be modified to specify which
version of MetaMapLite you wish to use.  Also, for the latest version
of MetaMapLite, it will be necessary to run 'mvn install' in the
public\_mm\_lite directory to make it available when compiling
metamaplite-rest.  The metamaplite version specified in the
dependencies of the metamaplite-rest pom.xml should be the same as the
version in the top of the public\_mm\_lite pom.xml.

# ReSTFul MetaMapLite URLs

## Suggested Requests

+ List of Options 
+ List of Available DataSets
+ List of Sources
+ List of Semantic Types
+ List of Supported Request Formats
+ List of Supported Response Formats
+ annotate input


## URL Examples

      Query url                                   description

      metamaplite/rest/options                    get list of options
      metamaplite/rest/options/list               
	  metamaplite/rest/options/info/segmentlines  get info on use of segmentlines
      metamaplite/rest/options/info/inputformat   get list of available input formats
	  metamaplite/rest/options/info/outputformat  get list of available output formats
      metamaplite/rest/datasets
      metamaplite/rest/datasets/list              get list of available data sets
      metamaplite/rest/datasets/info/base.2016AB  get info on data set base.2016AB
      metamaplite/rest/sources                    
      metamaplite/rest/sources/list               get list of sources
      metamaplite/rest/sources/info/msh
      metamaplite/rest/semantictypes              get list of semantic types
      metamaplite/rest/requestcontenttypes        get list of available content-types for requests
      metamaplite/rest/requestcontenttypes/list
      metamaplite/rest/responsecontenttypes
      metamaplite/rest/responsecontenttypes/list  get list of available content-types for responses
      metamaplite/rest/annotate                   annotate input document (POST) or term (GET)
	  metamaplite/rest/chunk                      chunk input document
	  metamaplite/rest/postag                     tag input document part of speech
	  metamaplite/rest/acronyms                   find acronyms/abbreviations in input document

      metamaplite/rest/annotate/plain


# Form submission encodings

## JSON (preferred format)

    content-type: application/json

## XML

    content-type: application/xml

## EDN

    content-type: application/edn

## YAML

    content-type: text/x-yaml

## Form URLEncoded

    content-type: application/x-www-form-urlencoded

## Multipart Form Data

    content-type: multipart/form-data

# response encodings

## text/plain

outputformats supported:

+ brat/standoff
+ MMI like
+ PubTator
+ 

## application/edn

outputformats supported:
To be determined

## application/xml

outputformats supported:

+ BioC XML
+ Others?


# content of requests

## annotation requests (POST)



## post dictionary

inputtext: input text
docformat: format of input document (freetext, medline, pubmed)
resultformat: format of result (mmi, brat, etc.)
sourceString: 
semanticTypeString:
