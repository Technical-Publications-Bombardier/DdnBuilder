# Data Dispatch Node Builder

This Gluon sample was generated from https://start.gluon.io

## Basic Requirements

A list of the basic requirements can be found online in the [Gluon documentation](https://docs.gluonhq.com/#_requirements).

## CloudLink Requirements

Since the Gluon CloudLink feature was selected when creating this sample, you will need an active CloudLink
subscription to be able to make full use of the CloudLink features. More details on how to register your application
can be read online in the [Gluon CloudLink documentation](https://docs.gluonhq.com/cloudlink/#_application_registration)

## Quick instructions

### Run the sample on JVM/HotSpot:

    mvn gluonfx:run

### Run the sample as a native image:

    mvn gluonfx:build gluonfx:nativerun

### Run the sample as a native android image:

    mvn -Pandroid gluonfx:build gluonfx:package gluonfx:install gluonfx:nativerun

### Run the sample as a native iOS image:

    mvn -Pios gluonfx:build gluonfx:package gluonfx:install gluonfx:nativerun

## Selected features

This is a list of all the features that were selected when creating the sample:

### JavaFX 21 Modules

 - javafx-base
 - javafx-graphics
 - javafx-controls
 - javafx-fxml

### Gluon Features

 - Glisten: build platform independent user interfaces
 - Glisten Afterburner: minimalistic dependency injection
 - Connect: load data resources
 - CloudLink: connect your enterprise to your client application
 - Attach display
 - Attach lifecycle
 - Attach statusbar
 - Attach storage
 - Attach device
 - Attach push notifications
 - Attach runtime args
