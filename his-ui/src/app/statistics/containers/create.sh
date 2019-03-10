#!/bin/bash
ng g component $1-container
cd ../components
ng g component $1
cd ../containers

