# A ReSTful service for MetaMapLite

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

      metamaplite/rest/options
      metamaplite/rest/options/list
	  metamaplite/rest/options/info/segmentlines
	  metamaplite/rest/options/info/outputformat
      metamaplite/rest/datasets
      metamaplite/rest/datasets/list
      metamaplite/rest/datasets/info/base.2016AB
      metamaplite/rest/sources
      metamaplite/rest/sources/list
      metamaplite/rest/sources/info/msh
      metamaplite/rest/semantictypes
      metamaplite/rest/requestcontenttypes
      metamaplite/rest/requestcontenttypes/list
      metamaplite/rest/responsecontenttypes
      metamaplite/rest/responsecontenttypes/list
      metamaplite/rest/annotate


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



